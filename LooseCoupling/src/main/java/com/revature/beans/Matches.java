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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Matches {
	
	@Id
	@Column (name="matches_id")
	@SequenceGenerator (name="matches", sequenceName="matches_seq", allocationSize=1)
	@GeneratedValue (generator="matches", strategy=GenerationType.SEQUENCE)
	private Integer matchesId;
	@OneToOne
	@JoinColumn (name="user1_id")
	private Users user1Id; 
	@OneToOne
	@JoinColumn (name="user2_id")
	private Users user2Id;
	@ManyToOne
	@JoinColumn(name="status_id")
	private Status matchStatus;
	//@OneToMany (fetch=FetchType.EAGER, mappedBy="matches")
	//@JoinColumn??
	@Column
	@ElementCollection(targetClass=Integer.class)
	private Set<Messages> matchMessages;
	//Should Match have two Users field (ex: private Users user1), or are IDs enough? YES!!!
	
	
		//OneToOne for each user...
	//Need @OneToOne mapping to status, given match has a status... or does statusId field cover it??
	
	//RICHARD DIDN'T LIKE MALE-FEMALE EXCLUSIVITY
	
	public Matches() {
		super();
	}

	public Matches(Integer matchesId) {
		super();
		this.matchesId = matchesId;
	}

	public Matches(Integer matchesId, Users user1Id, Users user2Id, Status matchStatus, Set<Messages> matchMessages) {
		super();
		this.matchesId = matchesId;
		this.user1Id = user1Id;
		this.user2Id = user2Id;
		this.matchStatus = matchStatus;
		this.matchMessages = matchMessages;
	}

	public Integer getMatchesId() {
		return matchesId;
	}

	public void setMatchesId(Integer matchesId) {
		this.matchesId = matchesId;
	}

	public Users getUser1Id() {
		return user1Id;
	}

	public void setMaleId(Users user1Id) {
		this.user1Id = user1Id;
	}

	public Users getUser2Id() {
		return user2Id;
	}

	public void setUser2Id(Users user2Id) {
		this.user2Id = user2Id;
	}

	public Status getMatchStatus() {
		return matchStatus;
	}

	public void setStatusId(Status matchStatus) {
		this.matchStatus = matchStatus;
	}
	
	public Set<Messages> getMatchMessages() {
		return matchMessages;
	}

	public void setMatchMessages(Set<Messages> matchMessages) {
		this.matchMessages = matchMessages;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user2Id == null) ? 0 : user2Id.hashCode());
		result = prime * result + ((user1Id == null) ? 0 : user1Id.hashCode());
		result = prime * result + ((matchMessages == null) ? 0 : matchMessages.hashCode());
		result = prime * result + ((matchesId == null) ? 0 : matchesId.hashCode());
		result = prime * result + ((matchStatus == null) ? 0 : matchStatus.hashCode());
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
		Matches other = (Matches) obj;
		if (user2Id == null) {
			if (other.user2Id != null)
				return false;
		} else if (!user2Id.equals(other.user2Id))
			return false;
		if (user1Id == null) {
			if (other.user1Id != null)
				return false;
		} else if (!user1Id.equals(other.user1Id))
			return false;
		if (matchMessages == null) {
			if (other.matchMessages != null)
				return false;
		} else if (!matchMessages.equals(other.matchMessages))
			return false;
		if (matchesId == null) {
			if (other.matchesId != null)
				return false;
		} else if (!matchesId.equals(other.matchesId))
			return false;
		if (matchStatus == null) {
			if (other.matchStatus != null)
				return false;
		} else if (!matchStatus.equals(other.matchStatus))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Matches [matchesId=" + matchesId + ", user1Id=" + user1Id + ", user2Id=" + user2Id + ", matchStatus="
				+ matchStatus + ", matchMessages=" + matchMessages + "]";
	}
	
}
