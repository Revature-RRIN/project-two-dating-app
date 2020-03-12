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

public class UsersHibernate implements UsersDAO{
	private HibernateUtil hu = HibernateUtil.getInstance();
	private Logger log = Logger.getLogger(UsersHibernate.class);

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
	
	public Users getUser(Users u) {
		Session s = hu.getSession();
		Users u2;
		log.trace(u);
		if(u.getUsersId()!=null && u.getUsersId()!=0) {
			//this means we're going to retrieve by id
			u2 = s.get(Users.class, u.getUsersId());
		} else {
			//this means we're getting by user/pass
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
