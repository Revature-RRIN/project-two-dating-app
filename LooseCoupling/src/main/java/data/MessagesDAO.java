package data;

import java.util.Set;

import beans.Matches;
import beans.Messages;
import beans.Status;
import beans.Users;

public interface MessagesDAO {
	public Integer addMessage(Messages msg);
	public Messages getMessageById(int id);
	public Messages getMessageByUser(Users u);
	public Set<Messages> getMessagesByMatch(Matches m);
	
	//ByStatus for Admin functionality... (so he/she can retrieve "deleted/reported" messages)?
	public Set<Messages> getMessageByStatus(Status s);

	//Do we need update?... Only if individual messages can be edited by user.
	public void updateMessages(Messages msg);
	
	public void deleteMessage(Messages msg);
}
