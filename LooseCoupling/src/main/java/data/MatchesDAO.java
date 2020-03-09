package data;

import java.util.Set;

import beans.Matches;
import beans.Users;

public interface MatchesDAO {
	public Integer addMatch(Matches m);
	public Matches getMatchById(int id);
	public Set<Matches> getAllMatches();
	public Set<Matches> getMatchesByUser(Users u);
	//getMatchByMessage? 
	//getMatchByStatus?
	public void updateMatch(Matches m);
	public void deleteMatch(Matches m);
}
