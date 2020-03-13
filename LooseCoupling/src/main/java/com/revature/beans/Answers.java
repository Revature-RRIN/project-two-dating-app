package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Answers {
	@Id
	@Column(name = "answers_id")
	@SequenceGenerator(name = "answers", sequenceName = "answers_seq", allocationSize = 1)
	@GeneratedValue(generator = "answers", strategy = GenerationType.SEQUENCE)
	private Integer answersId;
	@Column(name = "which_question_id")
	private Questions whichQuestion;
	@Column
	private Integer response;
	
	//QUESTION; NOT ID!!
	
	// Need @ManyToOne mapping for user?? Given answers have a user that provided
	// the answers??

	// RICHARD WANTS ADMIN TO BE ABLE TO ADD QUESTIONS

	public Answers() {
		super();
	}

	public Answers(Integer answersId) {
		super();
		this.answersId = answersId;
	}

	public Answers(Integer answersId, Questions whichQuestion, Integer response) {
		super();
		this.answersId = answersId;
		this.whichQuestion = whichQuestion;
		this.response = response;
	}

	public Integer getAnswersId() {
		return answersId;
	}

	public void setAnswersId(Integer answersId) {
		this.answersId = answersId;
	}

	public Questions getWhichQuestion() {
		return whichQuestion;
	}

	public void setWhichQuestionId(Questions whichQuestion) {
		this.whichQuestion = whichQuestion;
	}

	public Integer getResponse() {
		return response;
	}

	public void setResponse(Integer response) {
		this.response = response;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answersId == null) ? 0 : answersId.hashCode());
		result = prime * result + ((response == null) ? 0 : response.hashCode());
		result = prime * result + ((whichQuestion == null) ? 0 : whichQuestion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Answers other = (Answers) obj;
		if (answersId == null) {
			if (other.answersId != null)
				return false;
		} else if (!answersId.equals(other.answersId))
			return false;
		if (response == null) {
			if (other.response != null)
				return false;
		} else if (!response.equals(other.response))
			return false;
		if (whichQuestion == null) {
			if (other.whichQuestion != null)
				return false;
		} else if (!whichQuestion.equals(other.whichQuestion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Answers [answersId=" + answersId + ", whichQuestion=" + whichQuestion + ", response=" + response
				+ "]";
	}

}
