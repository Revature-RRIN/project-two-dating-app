package com.revature.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	//@OneToOne (cascade = CascadeType.ALL)
	//@JoinColumn (name="matchesId")
	//@Column
	//@ElementCollection(targetClass=Integer.class)
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "matchesId", cascade = CascadeType.ALL)
	private Set<Matches> matchByStatus;
	
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

	public Set<Matches> getMatchByStatus() {
		return matchByStatus;
	}


	public void setMatchByStatus(Set<Matches> matchByStatus) {
		this.matchByStatus = matchByStatus;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matchByStatus == null) ? 0 : matchByStatus.hashCode());
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
		if (matchByStatus == null) {
			if (other.matchByStatus != null)
				return false;
		} else if (!matchByStatus.equals(other.matchByStatus))
			return false;
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
		return "Status [statusId=" + statusId + ", statusState=" + statusState + ", matchByStatus=" + matchByStatus
				+ "]";
	}

}
