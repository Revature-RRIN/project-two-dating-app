package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
		
}
