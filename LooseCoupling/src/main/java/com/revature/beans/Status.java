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
public class Status {

	@Id
	@Column(name = "status_id")
	@SequenceGenerator(name = "status", sequenceName = "status_seq", allocationSize = 1)
	@GeneratedValue(generator = "status", strategy = GenerationType.SEQUENCE)
	private Integer statusId;
	@Column(name = "status_state")
	private String statusState;
	
	//Need @OneToOne for matches (b/c each status refers to a match, and each match has a status)??

	
	public Status() {
		super();
	}

	
	public Status(Integer statusId) {
		super();
		this.statusId = statusId;
	}


	public Status(Integer statusId, String statusState) {
		super();
		this.statusId = statusId;
		this.statusState = statusState;
	}

	
	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getStatusState() {
		return statusState;
	}

	public void setStatusState(String statusState) {
		this.statusState = statusState;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((statusId == null) ? 0 : statusId.hashCode());
		result = prime * result + ((statusState == null) ? 0 : statusState.hashCode());
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
		Status other = (Status) obj;
		if (statusId == null) {
			if (other.statusId != null)
				return false;
		} else if (!statusId.equals(other.statusId))
			return false;
		if (statusState == null) {
			if (other.statusState != null)
				return false;
		} else if (!statusState.equals(other.statusState))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Status [statusId=" + statusId + ", statusState=" + statusState + "]";
	}

}
