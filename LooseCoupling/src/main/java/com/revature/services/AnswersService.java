package com.revature.services;

import java.util.Set;

import com.revature.beans.Answers;
import com.revature.beans.Users;

public interface AnswersService {
	public Integer addAnswer(Answers a); //returns ID for a given set of Answers
	public Set<Answers> getAnswersByUser(Users u);
	public Set<Answers> getAllAnswers(); //...might need for Services layer	
	public void updateAnswer(Answers a);
	public void deleteAnswers(Answers a);
}
