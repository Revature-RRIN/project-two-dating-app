package data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import beans.Users;
import utils.HibernateUtil;
import utils.LogUtil;

public class UsersHibernate implements UsersDAO{
	private HibernateUtil hu = HibernateUtil.getInstance();

	public Integer addUser(Users u) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(u);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, UsersHibernate.class);
		} finally {
			s.close();
		}
		return u.getUsersId();
	}

	public Users getUser(String username, String password) {
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

	public void updateUser(Users u) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(u);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, UsersHibernate.class);
		} finally {
			s.close();
		}
	}

	public void deleteUser(Users u) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.delete(u);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, UsersHibernate.class);
		} finally {
			s.close();
		}
	}

}
