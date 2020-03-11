package com.revature.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.beans.Matches;
import com.revature.beans.Status;
import com.revature.data.StatusDAO;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;


public class StatusHibernate implements StatusDAO{
	private HibernateUtil hu = HibernateUtil.getInstance();

	public Status getStatusById(int id) {
		Session s = hu.getSession();
		Status stat = s.get(Status.class, id);
		s.close();
		return stat;
	}

	
	public Status getStatusByMatch(Matches m) {
		Session s = hu.getSession();
		String query = "FROM Status stat where stat.matches = :matches";
		Query<Status> q = s.createQuery(query, Status.class);
		q.setParameter("matches", m);
		Status stat = q.uniqueResult();
		s.close();
		return stat;
	}
	

	public Set<Status> getAllStatuses() {
		Session s = hu.getSession();
		String query = "FROM Status";
		Query<Status> q = s.createQuery(query, Status.class);
		List<Status> statusList = q.getResultList();
		Set<Status> statusSet = new HashSet<Status>();
		statusSet.addAll(statusList);
		s.close();
		return statusSet;
	}

	public void updateStatus(Status stat) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(stat);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, StatusHibernate.class);
		} finally {
			s.close();
		}
	}

}
