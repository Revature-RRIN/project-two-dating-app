package com.revature.services;

import java.util.Set;

import com.revature.beans.Matches;
import com.revature.beans.Users;
import com.revature.data.MatchesDAO;
import com.revature.data.hibernate.MatchesHibernate;

public class MatchesServiceHibernate implements MatchesService{
	private MatchesDAO md = new MatchesHibernate();
	
	@Override
	public Integer addMatch(Matches m) {
		return md.addMatch(m);
	}

	@Override
	public Matches getMatchById(int id) {
		return md.getMatchById(id);
	}

	@Override
	public Set<Matches> getMatchesByUser(Users u) {
		return md.getMatchesByUser(u);
	}

	@Override
	public void updateMatch(Matches m) {
		md.updateMatch(m);
	}

	@Override
	public void deleteMatch(Matches m) {
		md.deleteMatch(m);
	}

}
