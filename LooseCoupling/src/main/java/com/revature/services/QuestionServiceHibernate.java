package com.revature.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.revature.beans.Questions;
import com.revature.data.QuestionsDAO;
import com.revature.data.hibernate.QuestionsHibernate;

@Service
public class QuestionServiceHibernate implements QuestionService {
	
	QuestionsDAO qd = new QuestionsHibernate ();

	@Override
	public Integer addQuestion(Questions q) {
		
		return qd.addQuestion(q);
	}

	@Override
	public Set<Questions> getAllQuestions() {
		
		return qd.getAllQuestions();
	}

	@Override
	public void deleteQuestions(Questions q) {
		
		qd.deleteQuestions(q);
	}

	@Override
	public Questions getQuestionById(Integer i) {
		
		return qd.getQuestionById(i);
	}

}
