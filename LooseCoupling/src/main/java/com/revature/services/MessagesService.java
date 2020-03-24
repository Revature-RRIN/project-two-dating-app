package com.revature.services;

import java.util.Set;

import com.revature.beans.Matches;
import com.revature.beans.Messages;
import com.revature.beans.Status;
import com.revature.beans.Users;

public interface MessagesService {
	public Integer addMessage(Messages msg);
	public Messages getMessageById(int id);
	public Set<Messages> getConversationByUsers(int u, int u2);
	public Set<Messages> getMessageByUser(Users u);
	public Set<Messages> getMessagesByMatch(Matches m);
	public Set<Messages> getMessageByStatus(Status s);
	public void updateMessages(Messages msg);	
	public void deleteMessage(Messages msg);
}