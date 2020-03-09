package data;

import java.util.Set;

import beans.Answers;
import beans.Users;

public interface AnswersDAO {
	public Integer addAnswer(Answers a); //returns ID for a given set of Answers
	public Integer getScoreByAnswersId(int id); //will return "cumulative score"
	public Answers getAnswersByUser(Users u);
	public Set<Answers> getAllAnswers(); //...might need for Services layer
	
	public void updateAnswer(Answers a);
	public void deleteAnswers(Answers a);
}
