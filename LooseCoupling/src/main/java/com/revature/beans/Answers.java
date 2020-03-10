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
	@Column (name="answers_id")
	@SequenceGenerator(name="answers", sequenceName="answers_seq", allocationSize=1)
	@GeneratedValue(generator="answers", strategy=GenerationType.SEQUENCE)
	private Integer answersId;
	@Column (name="answer_1")
	private Integer answer1;
	@Column (name="answer_2")
	private Integer answer2;
	@Column (name="answer_3")
	private Integer answer3;
	@Column (name="answer_4")
	private Integer answer4;
	@Column
	private Integer cumulative;
	
	//Need @ManyToOne mapping for user?? Given answers have a user that provided the answers??
	
	//NOT 1ST NORMAL FORM!!... NEED TO CHANGE
	//RICHARD WANTS ADMIN TO BE ABLE TO ADD QUESTIONS
	
	public Answers() {
		super();
	}
	public Answers(Integer answersId) {
		super();
		this.answersId = answersId;
	}
	public Answers(Integer answersId, Integer answer1, Integer answer2, Integer answer3, Integer answer4,
			Integer cumulative) {
		super();
		this.answersId = answersId;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
		this.cumulative = cumulative;
	}
	
	
	public Integer getAnswersId() {
		return answersId;
	}
	public void setAnswersId(Integer answersId) {
		this.answersId = answersId;
	}
	public Integer getAnswer1() {
		return answer1;
	}
	public void setAnswer1(Integer answer1) {
		this.answer1 = answer1;
	}
	public Integer getAnswer2() {
		return answer2;
	}
	public void setAnswer2(Integer answer2) {
		this.answer2 = answer2;
	}
	public Integer getAnswer3() {
		return answer3;
	}
	public void setAnswer3(Integer answer3) {
		this.answer3 = answer3;
	}
	public Integer getAnswer4() {
		return answer4;
	}
	public void setAnswer4(Integer answer4) {
		this.answer4 = answer4;
	}
	public Integer getCumulative() {
		return cumulative;
	}
	public void setCumulative(Integer cumulative) {
		this.cumulative = cumulative;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer1 == null) ? 0 : answer1.hashCode());
		result = prime * result + ((answer2 == null) ? 0 : answer2.hashCode());
		result = prime * result + ((answer3 == null) ? 0 : answer3.hashCode());
		result = prime * result + ((answer4 == null) ? 0 : answer4.hashCode());
		result = prime * result + ((answersId == null) ? 0 : answersId.hashCode());
		result = prime * result + ((cumulative == null) ? 0 : cumulative.hashCode());
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
		if (answer1 == null) {
			if (other.answer1 != null)
				return false;
		} else if (!answer1.equals(other.answer1))
			return false;
		if (answer2 == null) {
			if (other.answer2 != null)
				return false;
		} else if (!answer2.equals(other.answer2))
			return false;
		if (answer3 == null) {
			if (other.answer3 != null)
				return false;
		} else if (!answer3.equals(other.answer3))
			return false;
		if (answer4 == null) {
			if (other.answer4 != null)
				return false;
		} else if (!answer4.equals(other.answer4))
			return false;
		if (answersId == null) {
			if (other.answersId != null)
				return false;
		} else if (!answersId.equals(other.answersId))
			return false;
		if (cumulative == null) {
			if (other.cumulative != null)
				return false;
		} else if (!cumulative.equals(other.cumulative))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Answers [answersId=" + answersId + ", answer1=" + answer1 + ", answer2=" + answer2 + ", answer3="
				+ answer3 + ", answer4=" + answer4 + ", cumulative=" + cumulative + "]";
	}
	
}
