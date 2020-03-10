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
public class Answers {
	@Id
	@Column(name = "answers_id")
	@SequenceGenerator(name = "answers", sequenceName = "answers_seq", allocationSize = 1)
	@GeneratedValue(generator = "answers", strategy = GenerationType.SEQUENCE)
	private Integer answersId;
	@Column(name = "which_question_id")
	private Integer whichQuestionId;
	@Column
	private Integer response;

	// Need @ManyToOne mapping for user?? Given answers have a user that provided
	// the answers??

	// NOT 1ST NORMAL FORM!!... NEED TO CHANGE
	// RICHARD WANTS ADMIN TO BE ABLE TO ADD QUESTIONS

	public Answers() {
		super();
	}

	public Answers(Integer answersId) {
		super();
		this.answersId = answersId;
	}

	public Answers(Integer answersId, Integer whichQuestionId, Integer response) {
		super();
		this.answersId = answersId;
		this.whichQuestionId = whichQuestionId;
		this.response = response;
	}

	public Integer getAnswersId() {
		return answersId;
	}

	public void setAnswersId(Integer answersId) {
		this.answersId = answersId;
	}

	public Integer getWhichQuestionId() {
		return whichQuestionId;
	}

	public void setWhichQuestionId(Integer whichQuestionId) {
		this.whichQuestionId = whichQuestionId;
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
		result = prime * result + ((whichQuestionId == null) ? 0 : whichQuestionId.hashCode());
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
		if (whichQuestionId == null) {
			if (other.whichQuestionId != null)
				return false;
		} else if (!whichQuestionId.equals(other.whichQuestionId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Answers [answersId=" + answersId + ", whichQuestionId=" + whichQuestionId + ", response=" + response
				+ "]";
	}

}
