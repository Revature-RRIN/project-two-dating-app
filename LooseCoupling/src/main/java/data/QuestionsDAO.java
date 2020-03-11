package data;

import java.util.Set;

import beans.Questions;

public interface QuestionsDAO {
	public Integer addQuestion(Questions q); 
	public Set<Questions> getAllQuestions(); 
	public void deleteQuestions(Questions q);
}
