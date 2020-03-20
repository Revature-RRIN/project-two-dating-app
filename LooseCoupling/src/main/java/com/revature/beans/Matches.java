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
	@Column(name = "matches_id")
	@SequenceGenerator(name = "matches", sequenceName = "matches_seq", allocationSize = 1)
	@GeneratedValue(generator = "matches", strategy = GenerationType.SEQUENCE)
	private Integer matchesId;
	@OneToOne
	@JoinColumn(name = "user1_id")
	private Users user1;
	@OneToOne
	@JoinColumn(name = "user2_id")
	private Users user2;
	@ManyToOne
	@JoinColumn(name = "status_id")
	private Status matchStatus;
	// @OneToMany (fetch=FetchType.EAGER, mappedBy="matches")
	// @JoinColumn??
	@Column
	@ElementCollection(targetClass = Integer.class)
	private Set<Messages> matchMessages;

	// Should Match have two Users field (ex: private Users user1), or are IDs
	// enough? YES!!!
	// OneToOne for each user...
	// Need @OneToOne mapping to status, given match has a status... or does
	// statusId field cover it??
	public Matches() {
		super();
	}

	public Matches(Users user1, Users user2) {
		super();
		this.user1 = user1;
		this.user2 = user2;
	}

	public Matches(Integer matchesId, Users user1, Users user2, Status matchStatus, Set<Messages> matchMessages) {
		super();
		this.matchesId = matchesId;
		this.user1 = user1;
		this.user2 = user2;
		this.matchStatus = matchStatus;
		this.matchMessages = matchMessages;
	}

	public Integer getMatchesId() {
		return matchesId;
	}

	public void setMatchesId(Integer matchesId) {
		this.matchesId = matchesId;
	}

	public Users getUser1() {
		return user1;
	}

	public void setUser1(Users user1) {
		this.user1 = user1;
	}

	public Users getUser2() {
		return user2;
	}

	public void setUser2(Users user2) {
		this.user2 = user2;
	}

	public Status getMatchStatus() {
		return matchStatus;
	}

	public void setMatchStatus(Status matchStatus) {
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
		result = prime * result + ((matchMessages == null) ? 0 : matchMessages.hashCode());
		result = prime * result + ((matchStatus == null) ? 0 : matchStatus.hashCode());
		result = prime * result + ((matchesId == null) ? 0 : matchesId.hashCode());
		result = prime * result + ((user1 == null) ? 0 : user1.hashCode());
		result = prime * result + ((user2 == null) ? 0 : user2.hashCode());
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
		if (matchMessages == null) {
			if (other.matchMessages != null)
				return false;
		} else if (!matchMessages.equals(other.matchMessages))
			return false;
		if (matchStatus == null) {
			if (other.matchStatus != null)
				return false;
		} else if (!matchStatus.equals(other.matchStatus))
			return false;
		if (matchesId == null) {
			if (other.matchesId != null)
				return false;
		} else if (!matchesId.equals(other.matchesId))
			return false;
		if (user1 == null) {
			if (other.user1 != null)
				return false;
		} else if (!user1.equals(other.user1))
			return false;
		if (user2 == null) {
			if (other.user2 != null)
				return false;
		} else if (!user2.equals(other.user2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Matches [matchesId=" + matchesId + ", user1=" + user1 + ", user2=" + user2 + ", matchStatus="
				+ matchStatus + ", matchMessages=" + matchMessages + "]";
	}

}
