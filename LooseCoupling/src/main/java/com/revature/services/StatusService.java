package com.revature.services;

import java.util.Set;

import com.revature.beans.Matches;
import com.revature.beans.Status;

public interface StatusService {
	//Do we need an Add Status method, or would they all be predefined...?
//	public Integer addStatus(Status s);
	
	public Status getStatusById(int id);
	public Status getStatusByMatch(Matches m);
	public Set<Status> getAllStatuses();
	public void updateStatus(Status stat);
	
	//Do we need a delete Status method?
//	public void deleteStatus(Status s); 
}
