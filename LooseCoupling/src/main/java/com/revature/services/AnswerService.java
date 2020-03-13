package com.revature.services;

import java.util.Set;

import com.revature.beans.Answers;
import com.revature.beans.Users;

public interface AnswerService {

	public Integer addAnswers(Answers a);
	public Set<Answers> getAnswersByUser(Users u);
	public Set<Answers> getAllAnswers();
	public void updateAnswers(Answers a);
	public void deleteAnswers(Answers a);
	public Answers getAnswersByUser(Integer id);
	
}
