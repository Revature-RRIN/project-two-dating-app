package com.revature.services;

import java.util.Set;

import com.revature.beans.Matches;
import com.revature.beans.Users;

public interface MatchesService {
	public Integer addMatch(Matches m);
	public Matches getMatchById(int id);
	public Set<Matches> getAllMatches();
	public Set<Matches> getMatchesByUser(Users u);
	public void updateMatch(Matches m);
	public void deleteMatch(Matches m);
	public Matches matchCompatibleUser(Users u1);
	public void matchByPersonalityType(Users u1);
	public void acceptMatch(Matches m);
	public void rejectMatch(Matches m);
}
