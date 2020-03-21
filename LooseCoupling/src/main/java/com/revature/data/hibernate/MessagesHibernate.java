package com.revature.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.beans.Matches;
import com.revature.beans.Messages;
import com.revature.beans.Status;
import com.revature.beans.Users;
import com.revature.data.MessagesDAO;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

public class MessagesHibernate implements MessagesDAO{
	private HibernateUtil hu = HibernateUtil.getInstance();
	
	public Set<Messages> getConversationByUsers(Users loggedUser, Users matchedUser)	{
		Session s = hu.getSession();
		String query = "FROM Messages msg where sender_id = :users_id AND receiver_id = :users_id2";
		Query<Messages> q = s.createQuery(query, Messages.class);
		q.setParameter("users_id", loggedUser.getUsersId());
		q.setParameter("users_id2", matchedUser.getUsersId());
		List<Messages> msgList = q.getResultList();
		Set<Messages> msgSet = new HashSet<Messages>();
		msgSet.addAll(msgList);
		s.close();
		return msgSet;
	}
	
	public Integer addMessage(Messages msg) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(msg);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, MessagesHibernate.class);
		} finally {
			s.close();
			System.out.println(msg + " penisbreath");
		}
		return msg.getMessagesId();
	}

	public Messages getMessageById(int id) {
		Session s = hu.getSession();
		Messages msg = s.get(Messages.class, id);
		s.close();
		return msg;
	}

	public Set<Messages> getMessageByUser(Users u) {
		Session s = hu.getSession();
		String query = "FROM Messages msg where :users = some elements(msg.users)";
		Query<Messages> q = s.createQuery(query, Messages.class);
		q.setParameter("users", u);
		List<Messages> msgList = q.getResultList();
		Set<Messages> msgSet = new HashSet<Messages>();
		msgSet.addAll(msgList);
		s.close();
		return msgSet;
	}

	public Set<Messages> getMessagesByMatch(Matches m) {
		Session s = hu.getSession();
		String query = "FROM Messages msg where :matches = some elements(msg.matches)";
		Query<Messages> q = s.createQuery(query, Messages.class);
		q.setParameter("matches", m);
		List<Messages> msgList = q.getResultList();
		Set<Messages> msgSet = new HashSet<Messages>();
		msgSet.addAll(msgList);
		s.close();
		return msgSet;
	}

	public Set<Messages> getMessageByStatus(Status s) {
		Session se = hu.getSession();
		String query = "FROM Messages msg where :status = some elements(msg.status)";
		Query<Messages> q = se.createQuery(query, Messages.class);
		q.setParameter("status", se);
		List<Messages> msgList = q.getResultList();
		Set<Messages> msgSet = new HashSet<Messages>();
		msgSet.addAll(msgList);
		se.close();
		return msgSet;
	}

	public void updateMessages(Messages msg) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(msg);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, MessagesHibernate.class);
		} finally {
			s.close();
		}
	}

	public void deleteMessage(Messages msg) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.delete(msg);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, MessagesHibernate.class);
		} finally {
			s.close();
		}
	}

}
