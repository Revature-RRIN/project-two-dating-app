package com.revature.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Questions {
	@Id
	@Column(name="question_id")
	@SequenceGenerator(name="questions", sequenceName="questions_seq", allocationSize=1)
	@GeneratedValue(generator="questions", strategy=GenerationType.SEQUENCE)
	private Integer questionId;
	@Column
	private String question;
	@OneToMany (mappedBy="questions")
	@JoinTable(name="user_answers",
	joinColumns=@JoinColumn(name="questions_id"),
	inverseJoinColumns=@JoinColumn(name="answers_id"))
	private Set<Answers> ans;
	
	
	
	public Questions() {
		super();
	}
	
	public Questions(Integer questionId) {
		super();
		this.questionId = questionId;
	}

	public Questions(Integer questionId, String question) {
		super();
		this.questionId = questionId;
		this.question = question;
	}

	
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Set<Answers> getAns() {
		return ans;
	}

	public void setAns(Set<Answers> ans) {
		this.ans = ans;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ans == null) ? 0 : ans.hashCode());
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		result = prime * result + ((questionId == null) ? 0 : questionId.hashCode());
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
		Questions other = (Questions) obj;
		if (ans == null) {
			if (other.ans != null)
				return false;
		} else if (!ans.equals(other.ans))
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		if (questionId == null) {
			if (other.questionId != null)
				return false;
		} else if (!questionId.equals(other.questionId))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "Questions [questionId=" + questionId + ", question=" + question + ", ans=" + ans + "]";
	}
		
	
	
}
