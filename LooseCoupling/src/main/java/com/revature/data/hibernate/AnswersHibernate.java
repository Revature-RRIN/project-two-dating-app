package com.revature.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.beans.Answers;
import com.revature.beans.Users;
import com.revature.data.AnswersDAO;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

public class AnswersHibernate implements AnswersDAO{
	
	public static void main(String[] args) {
		AnswersDAO ad = new AnswersHibernate();
		Answers a = new Answers(5);
		ad.addAnswer(null);
	}
	
	private HibernateUtil hu = HibernateUtil.getInstance();

	public Integer addAnswer(Answers a) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(a);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, AnswersHibernate.class);
		} finally {
			s.close();
		}
		return a.getAnswersId();

	}

	public Set<Answers> getAnswersByUser(Users u) {
		Session s = hu.getSession();
		String query = "FROM Answers a where :users = some elements(a.users)";
		Query<Answers> q = s.createQuery(query, Answers.class);
		q.setParameter("user", u);
		List<Answers> answerList = q.getResultList();
		Set<Answers> answerSet = new HashSet<Answers>();
		answerSet.addAll(answerList);
		s.close();
		return answerSet;
	}

	public Set<Answers> getAllAnswers() {
		Session s = hu.getSession();
		String query = "FROM Answers";
		Query<Answers> q = s.createQuery(query, Answers.class);
		List<Answers> answerList = q.getResultList();
		Set<Answers> answerSet = new HashSet<Answers>();
		answerSet.addAll(answerList);
		s.close();
		return answerSet;
	}

	public void updateAnswer(Answers a) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(a);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, AnswersHibernate.class);
		} finally {
			s.close();
		}
	}

	public void deleteAnswers(Answers a) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.delete(a);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, AnswersHibernate.class);
		} finally {
			s.close();
		}
	}
	
	@Override
	public Answers getAnswersById(Integer i) {
		Session s = hu.getSession();
		Answers a = s.get(Answers.class, i);
		s.close();
		return a;
	}

}
