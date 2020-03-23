package com.revature.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.beans.Users;
import com.revature.data.UsersDAO;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

public class UsersHibernate implements UsersDAO {
	public static void main(String[] args) {
		UsersDAO ud = new UsersHibernate();
		Users u = ud.getUserById(5);
		ud.getCompatibleUser(u);
	}

	private HibernateUtil hu = HibernateUtil.getInstance();
	private Logger log = Logger.getLogger(UsersHibernate.class);

	public Integer addUser(Users u) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(u);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, UsersHibernate.class);
		} finally {
			s.close();
		}
		return u.getUsersId();
	}

	public Users getUser(Users u) {
		Session s = hu.getSession();
		Users u2;
		log.trace(u);
		if (u.getUsersId() != null && u.getUsersId() != 0) {
			// this means we're going to retrieve by id
			u2 = s.get(Users.class, u.getUsersId());
		} else {
			// this means we're getting by user/pass
			String query = "from Users u2 where u2.username=:username and u2.pass=:pass";
			Query<Users> q = s.createQuery(query, Users.class);
			q.setParameter("username", u.getUsername());
			q.setParameter("pass", u.getPass());
			u2 = q.uniqueResult();
		}
		s.close();
		return u2;
	}

	public Users getUserByUandP(String username, String password) {
		Session s = hu.getSession();
		String query = "FROM Users u where u.username = :username and u.pass = :pass";
		Query<Users> q = s.createQuery(query, Users.class);
		q.setParameter("username", username);
		q.setParameter("pass", password);
		Users u = q.uniqueResult();
		s.close();
		return u;
	}

	public Users getUserById(Integer id) {
		Session s = hu.getSession();
		Users u = s.get(Users.class, id);
		s.close();
		return u;
	}

	public Set<Users> getAllUsers() {
		Session s = hu.getSession();
		String query = "FROM Users";
		Query<Users> q = s.createQuery(query, Users.class);
		List<Users> usersList = q.getResultList();
		Set<Users> usersSet = new HashSet<Users>();
		usersSet.addAll(usersList);
		s.close();
		return usersSet;
	}

	public Users updateUser(Users u) {
		System.out.println(u);
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(u);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, UsersHibernate.class);
		} finally {
			s.close();
		}
		System.out.println(u);
		return u;
	}

	public void deleteUser(Users u) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.delete(u);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, UsersHibernate.class);
		} finally {
			s.close();
		}
	}

	//This is the old one I used just for testing
	@Override
	public Users getCompatibleUser(Users u) {
		System.out.println("Calculating minimum difference.");
		int diff = Integer.MAX_VALUE;
		int index = 0;
		UsersDAO ud = new UsersHibernate();
		Set<Users> usersSet = ud.getAllUsers();
		for (Users user : usersSet) {
			if (!(user.getUsersId() == u.getUsersId())) {
				if (Math.abs((user.getScore() - u.getScore())) < diff) {
					diff = Math.abs((user.getScore() - u.getScore()));
					index = user.getUsersId();
				}

			}
		}
		System.out.println("The best match is... " + ud.getUserById(index).getFirstname());
		return ud.getUserById(index);
	}

	@Override
	public Set<Users> getCompatibleUserGroup(Users u) {
		Set<Users> compatibles = new HashSet<Users>();
		UsersDAO ud = new UsersHibernate();
		// First assign the user a type by their score
		int type;
		if (u.getScore() < 225) {
			type = 1;
		} else if (u.getScore() >= 225 && u.getScore() < 275) {
			type = 2;
		} else if (u.getScore() >= 275 && u.getScore() < 325) {
			type = 3;
		} else {
			type = 4;
		}

		// Get user's preferences
		int pref = 0;
		if (u.getSexPref().equalsIgnoreCase("Heterosexual")) {
			pref = 1;
		} else if (u.getSexPref().equalsIgnoreCase("Homosexual")) {
			pref = 2;
		} else {
			pref = 3;
		}

		// Retrieve a group of users that match above variables
		Set<Users> usersSet = ud.getAllUsers();
		for (Users user : usersSet) {
			if (!(user.getUsersId() == u.getUsersId())) { // A user shouldn't get matched with himself
				if (type == 1) { // Personality type 1
					if (user.getScore() < 225) {
						if (pref == 1) { // User is straight
							if (!u.getGender().equalsIgnoreCase(user.getGender())) {
								if (user.getSexPref().equalsIgnoreCase("Heterosexual")) { // Make sure other user is also straight
									if (user.getAgePref() >= (u.getAgePref() - 5) && user.getAgePref() <= (u.getAgePref() + 5)) { // Check age range
										compatibles.add(user);
									}
								}			
							}
						} else if (pref == 2) { // User is gay
							if (u.getGender().equalsIgnoreCase(user.getGender())) {
								if (user.getSexPref().equalsIgnoreCase("Homosexual")) { // Make sure other user is also gay
									if (user.getAgePref() >= (u.getAgePref() - 5) && user.getAgePref() <= (u.getAgePref() + 5)) { // Check age range
										compatibles.add(user);
									}
								}		
							}
						}
					}
				} else if (type == 2) { // Personality type 2
					if (user.getScore() >= 225 && user.getScore() < 275) {
						if (pref == 1) { // User is straight
							if (!u.getGender().equalsIgnoreCase(user.getGender())) {
								if (user.getSexPref().equalsIgnoreCase("Heterosexual")) { // Make sure other user is also straight
									if (user.getAgePref() >= (u.getAgePref() - 5) && user.getAgePref() <= (u.getAgePref() + 5)) { // Check age range
										compatibles.add(user);
									}
								}			
							}
						} else if (pref == 2) { // User is gay
							if (u.getGender().equalsIgnoreCase(user.getGender())) {
								if (user.getSexPref().equalsIgnoreCase("Homosexual")) { // Make sure other user is also gay
									if (user.getAgePref() >= (u.getAgePref() - 5) && user.getAgePref() <= (u.getAgePref() + 5)) { // Check age range
										compatibles.add(user);
									}
								}		
							}
						}
					}
				} else if (type == 3) { // Personality type 3
					if (user.getScore() >= 275 && user.getScore() < 325) {
						if (pref == 1) { // User is straight
							if (!u.getGender().equalsIgnoreCase(user.getGender())) {
								if (user.getSexPref().equalsIgnoreCase("Heterosexual")) { // Make sure other user is also straight
									if (user.getAgePref() >= (u.getAgePref() - 5) && user.getAgePref() <= (u.getAgePref() + 5)) { // Check age range
										compatibles.add(user);
									}
								}			
							}
						} else if (pref == 2) { // User is gay
							if (u.getGender().equalsIgnoreCase(user.getGender())) {
								if (user.getSexPref().equalsIgnoreCase("Homosexual")) { // Make sure other user is also gay
									if (user.getAgePref() >= (u.getAgePref() - 5) && user.getAgePref() <= (u.getAgePref() + 5)) { // Check age range
										compatibles.add(user);
									}
								}		
							}
						}
					}
				} else { // Personality type 4
					if (user.getScore() >= 325) {
						if (pref == 1) { // User is straight
							if (!u.getGender().equalsIgnoreCase(user.getGender())) {
								if (user.getSexPref().equalsIgnoreCase("Heterosexual")) { // Make sure other user is also straight
									if (user.getAgePref() >= (u.getAgePref() - 5) && user.getAgePref() <= (u.getAgePref() + 5)) { // Check age range
										compatibles.add(user);
									}
								}			
							}
						} else if (pref == 2) { // User is gay
							if (u.getGender().equalsIgnoreCase(user.getGender())) {
								if (user.getSexPref().equalsIgnoreCase("Homosexual")) { // Make sure other user is also gay
									if (user.getAgePref() >= (u.getAgePref() - 5) && user.getAgePref() <= (u.getAgePref() + 5)) { // Check age range
										compatibles.add(user);
									}
								}		
							}
						}
					}
				}
			}
		}
		return compatibles;
	}

}
