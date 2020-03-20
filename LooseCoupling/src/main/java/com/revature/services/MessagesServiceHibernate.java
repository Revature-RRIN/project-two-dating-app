package com.revature.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.revature.beans.Matches;
import com.revature.beans.Messages;
import com.revature.beans.Status;
import com.revature.beans.Users;
import com.revature.data.MessagesDAO;
import com.revature.data.hibernate.MessagesHibernate;

@Service
public class MessagesServiceHibernate implements MessagesService{
	private MessagesDAO md = new MessagesHibernate();
	
	@Override
	public Integer addMessage(Messages msg) {
		return md.addMessage(msg);
	}

	@Override
	public Messages getMessageById(int id) {
		return md.getMessageById(id);
	}

	@Override
	public Set<Messages> getMessageByUser(Users u) {
		return md.getMessageByUser(u);
	}

	@Override
	public Set<Messages> getMessagesByMatch(Matches m) {
		return md.getMessagesByMatch(m);
	}

	@Override
	public Set<Messages> getMessageByStatus(Status s) {
		return md.getMessageByStatus(s);
	}

	@Override
	public void updateMessages(Messages msg) {
		md.updateMessages(msg);
		
	}

	@Override
	public void deleteMessage(Messages msg) {
		md.deleteMessage(msg);
	}

	@Override
	public Set<Messages> getConversationByUsers(Users u, Users u2) {
		return md.getConversationByUsers(u, u2);
	}

}
