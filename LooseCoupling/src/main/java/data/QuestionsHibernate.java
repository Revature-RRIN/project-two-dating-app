package data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import beans.Questions;
import utils.HibernateUtil;
import utils.LogUtil;

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

}
