package com.revature.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.beans.Questions;
import com.revature.data.QuestionsDAO;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

public class QuestionsHibernate implements QuestionsDAO{
	private HibernateUtil hu = HibernateUtil.getInstance();

	public Integer addQuestion(Questions q) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(q);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, QuestionsHibernate.class);
		} finally {
			s.close();
		}
		return q.getQuestionId();
	}

	public Set<Questions> getAllQuestions() {
		Session s = hu.getSession();
		String query = "FROM Questions";
		Query<Questions> q = s.createQuery(query, Questions.class);
		List<Questions> questionList = q.getResultList();
		Set<Questions> questionSet = new HashSet<Questions>();
		questionSet.addAll(questionList);
		s.close();
		return questionSet;
	}

	public void deleteQuestions(Questions q) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.delete(q);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, QuestionsHibernate.class);
		} finally {
			s.close();
		}
	}
	
	@Override
	public Questions getQuestionById(Integer i) {
		Session s = hu.getSession();
		Questions b = s.get(Questions.class, i);
		s.close();
		return b;
	}

}
