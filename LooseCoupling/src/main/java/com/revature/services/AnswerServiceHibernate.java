package com.revature.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.revature.beans.Answers;
import com.revature.beans.Users;
import com.revature.data.AnswersDAO;
import com.revature.data.hibernate.AnswersHibernate;

@Service
public class AnswerServiceHibernate implements AnswerService {
	
	private AnswersDAO ad = new AnswersHibernate();

	@Override
	public Integer addAnswers(Answers a) {
		
		return ad.addAnswer(a);
	}

	@Override
	public Set<Answers> getAnswersByUser(Users u) {
		
		return ad.getAnswersByUser(u);
	}

	@Override
	public Set<Answers> getAllAnswers() {
		
		return ad.getAllAnswers();
	}

	@Override
	public void updateAnswers(Answers a) {
		
		ad.updateAnswer(a);
		
	}

	@Override
	public void deleteAnswers(Answers a) {

		ad.deleteAnswers(a);
		
	}

	@Override
	public Answers getAnswersByUser(Integer id) {
		
		return ad.getAnswersById(id) ;
	}

}
