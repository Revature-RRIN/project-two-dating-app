package beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
	@Column
	private Integer maleId;
	@Column
	private Integer femaleId;
	@Column
	private Integer statusId;
	@OneToMany (fetch=FetchType.EAGER, mappedBy="matches")
	//@JoinColumn??
	private Set<Messages> matchMessages;
	//Should Match have two Users field (ex: private Users user1), or are IDs enough?
	
	//Need @OneToMany mapping to users (as a set), as well as IDs??
		//OneToOne for each user...
	//Need @OneToOne mapping to status, given match has a status... or does statusId field cover it??
	
	//RICHARD DIDN'T LIKE MALE-FEMALE EXCLUSIVITY...
	
	public Matches() {
		super();
	}

	public Matches(Integer matchesId) {
		super();
		this.matchesId = matchesId;
	}

	public Matches(Integer matchesId, Integer maleId, Integer femaleId, Integer statusId, Set<Messages> matchMessages) {
		super();
		this.matchesId = matchesId;
		this.maleId = maleId;
		this.femaleId = femaleId;
		this.statusId = statusId;
		this.matchMessages = matchMessages;
	}

	public Integer getMatchesId() {
		return matchesId;
	}

	public void setMatchesId(Integer matchesId) {
		this.matchesId = matchesId;
	}

	public Integer getMaleId() {
		return maleId;
	}

	public void setMaleId(Integer maleId) {
		this.maleId = maleId;
	}

	public Integer getFemaleId() {
		return femaleId;
	}

	public void setFemaleId(Integer femaleId) {
		this.femaleId = femaleId;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
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
		result = prime * result + ((femaleId == null) ? 0 : femaleId.hashCode());
		result = prime * result + ((maleId == null) ? 0 : maleId.hashCode());
		result = prime * result + ((matchMessages == null) ? 0 : matchMessages.hashCode());
		result = prime * result + ((matchesId == null) ? 0 : matchesId.hashCode());
		result = prime * result + ((statusId == null) ? 0 : statusId.hashCode());
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
		if (femaleId == null) {
			if (other.femaleId != null)
				return false;
		} else if (!femaleId.equals(other.femaleId))
			return false;
		if (maleId == null) {
			if (other.maleId != null)
				return false;
		} else if (!maleId.equals(other.maleId))
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
		if (statusId == null) {
			if (other.statusId != null)
				return false;
		} else if (!statusId.equals(other.statusId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Matches [matchesId=" + matchesId + ", maleId=" + maleId + ", femaleId=" + femaleId + ", statusId="
				+ statusId + ", matchMessages=" + matchMessages + "]";
	}
	
}
