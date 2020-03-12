package com.revature.services;

import java.util.Set;

import com.revature.beans.Matches;
import com.revature.beans.Messages;
import com.revature.beans.Status;
import com.revature.beans.Users;

public interface MessagesService {
	public Integer addMessage(Messages msg);
	public Messages getMessageById(int id);
	public Set<Messages> getMessageByUser(Users u);
	public Set<Messages> getMessagesByMatch(Matches m);
	
	//ByStatus for Admin functionality... (so he/she can retrieve "deleted/reported" messages)?
	public Set<Messages> getMessageByStatus(Status s);

	//Do we need update?... Only if individual messages can be edited by user.
	public void updateMessages(Messages msg);
	
	public void deleteMessage(Messages msg);
}
