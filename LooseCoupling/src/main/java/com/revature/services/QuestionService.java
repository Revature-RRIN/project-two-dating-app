package com.revature.services;

import java.util.Set;

import com.revature.beans.Questions;

public interface QuestionService {

	public Integer addQuestion(Questions q);
	public Set<Questions> getAllQuestions();
	public void deleteQuestions(Questions q);
	public Questions getQuestionById(Integer i);
	
}
