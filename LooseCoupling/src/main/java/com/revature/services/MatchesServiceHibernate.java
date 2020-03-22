package com.revature.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.revature.beans.Matches;
import com.revature.beans.Users;
import com.revature.data.MatchesDAO;
import com.revature.data.hibernate.MatchesHibernate;

@Service
public class MatchesServiceHibernate implements MatchesService {
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
	public Matches matchCompatibleUser(Users u1) {
		return md.matchCompatibleUser(u1);
	}

	@Override
	public void deleteMatch(Matches m) {
		md.deleteMatch(m);
	}

	@Override
	public void acceptMatch(Matches m) {
		md.acceptMatch(m);

	}

	@Override
	public void rejectMatch(Matches m) {
		md.rejectMatch(m);

	}

	@Override
	public Set<Matches> getAllMatches() {
		return md.getAllMatches();
	}

}
