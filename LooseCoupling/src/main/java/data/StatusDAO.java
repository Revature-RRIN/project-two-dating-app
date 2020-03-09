package data;

import java.util.Set;

import beans.Matches;
import beans.Status;

public interface StatusDAO {
	//Do we need an Add Status method, or would they all be predefined...?
//	public Integer addStatus(Status s);
	
	public Status getStatusById(int id);
	public Status getStatusByMatch(Matches m);
	public Set<Status> getAllStatuses();
	public void updateStatus(Status s);
	
	//Do we need a delete Status method?
//	public void deleteStatus(Status s); 
}
