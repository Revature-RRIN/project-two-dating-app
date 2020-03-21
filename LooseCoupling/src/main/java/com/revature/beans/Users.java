package com.revature.beans;

import java.sql.Blob;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
//Do we need to classify (name="" field)??
public class Users {
	@Id
	@Column(name = "users_id")
	@SequenceGenerator(name = "users", sequenceName = "users_seq", allocationSize = 1)
	@GeneratedValue(generator = "users", strategy = GenerationType.SEQUENCE)
	private Integer usersId;
	@Column
	private Integer usertype;
	@Column
	private String username;
	@Column
	// @JsonIgnore?
	private String pass;
	@Column
	private String firstname;
	@Column
	private String lastname;
	// @Column
	// DON'T GO BLOB ROUTE! S3 INTEGRATION
	// private Blob profilepic;
	@Column
	private Integer score;
	@Column
	private Integer age;
	@Column
	private String gender;
	@Column
	private String location;
	@Column
	private String banned;
	@Column(name = "sex_pref")
	private String sexPref;
	@Column(name = "age_pref")
	private Integer agePref;

	/*
	 * @ManyToMany (fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	 * 
	 * @JoinTable (name="MATCH_USER", joinColumns=@JoinColumn(name="users_id"),
	 * inverseJoinColumns=@JoinColumn(name="matches_id"))
	 */

	@Transient
	private Set<Matches> userMatches;

	/*
	 * @ManyToMany (fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	 * 
	 * @JoinTable (name="MESSAGES_USER", joinColumns=@JoinColumn(name="users_id"),
	 * inverseJoinColumns=@JoinColumn(name="messages_id"))
	 */

	@Transient
	private Set<Messages> sentMessages;
	@Transient
	private Set<Messages> receivedMessages;

	// ^^SENT VS RECEIVED MESSAGES AS INDIVUDAL SET FIELDS

	// RETRIEVE MATCHES AND USERS SEPERATELY ON FRONT-END; AND THEN PUT MATCHES INTO
	// THE USER

	// Need @OneToMany mapping for answers (as a set)?? Or does the cumulative
	// "score" field suffice??
	// ...Will we ever need to retrieve answers individually??

	// Need to remove recursive elements (userMatches and userMessages)
	// from .hascode(), .equals(), and .toString()

	public Users() {
		super();
	}

	public Users(Integer usersId) {
		super();
		this.usersId = usersId;
	}

	public Users(String username, String pass) {
		super();
		this.username = username;
		this.pass = pass;
	}

	public Users(Integer usersId, Integer usertype, String username, String pass, String firstname, String lastname,
			Blob profilepic, Integer score, Integer age, String gender, String location, String banned,
			Set<Matches> userMatches, Set<Messages> sentMessages, Set<Messages> receivedMessages, String sexPref,
			Integer agePref) {
		super();
		this.usersId = usersId;
		this.usertype = usertype;
		this.username = username;
		this.pass = pass;
		this.firstname = firstname;
		this.lastname = lastname;
		// this.profilepic = profilepic;
		this.score = score;
		this.age = age;
		this.gender = gender;
		this.location = location;
		this.banned = banned;
		this.userMatches = userMatches;
		this.sentMessages = sentMessages;
		this.receivedMessages = receivedMessages;
		this.sexPref = sexPref;
		this.agePref = agePref;
	}

	public Users(String firstname, String lastname, Integer age, String gender, String location, String sexPref,
			Integer agePref) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.gender = gender;
		this.location = location;
		this.sexPref = sexPref;
		this.agePref = agePref;
	}

	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public Integer getUsertype() {
		return usertype;
	}

	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/*
	 * /public Blob getProfilepic() { return profilepic; }
	 * 
	 * public void setProfilepic(Blob profilepic) { this.profilepic = profilepic; }
	 */

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBanned() {
		return banned;
	}

	public void setBanned(String banned) {
		this.banned = banned;
	}

	public Set<Matches> getUserMatches() {
		return userMatches;
	}

	public void setUserMatches(Set<Matches> userMatches) {
		this.userMatches = userMatches;
	}

	public Set<Messages> getSentMessages() {
		return sentMessages;
	}

	public void setSentMessages(Set<Messages> sentMessages) {
		this.sentMessages = sentMessages;
	}

	public Set<Messages> getReceivedMessages() {
		return receivedMessages;
	}

	public void setReceivedMessages(Set<Messages> receivedMessages) {
		this.receivedMessages = receivedMessages;
	}

	public String getSexPref() {
		return sexPref;
	}

	public void setSexPref(String sexPref) {
		this.sexPref = sexPref;
	}

	public Integer getAgePref() {
		return agePref;
	}

	public void setAgePref(Integer agePref) {
		this.agePref = agePref;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((agePref == null) ? 0 : agePref.hashCode());
		result = prime * result + ((banned == null) ? 0 : banned.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((receivedMessages == null) ? 0 : receivedMessages.hashCode());
		result = prime * result + ((score == null) ? 0 : score.hashCode());
		result = prime * result + ((sentMessages == null) ? 0 : sentMessages.hashCode());
		result = prime * result + ((sexPref == null) ? 0 : sexPref.hashCode());
		result = prime * result + ((userMatches == null) ? 0 : userMatches.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((usersId == null) ? 0 : usersId.hashCode());
		result = prime * result + ((usertype == null) ? 0 : usertype.hashCode());
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
		Users other = (Users) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (agePref == null) {
			if (other.agePref != null)
				return false;
		} else if (!agePref.equals(other.agePref))
			return false;
		if (banned == null) {
			if (other.banned != null)
				return false;
		} else if (!banned.equals(other.banned))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (receivedMessages == null) {
			if (other.receivedMessages != null)
				return false;
		} else if (!receivedMessages.equals(other.receivedMessages))
			return false;
		if (score == null) {
			if (other.score != null)
				return false;
		} else if (!score.equals(other.score))
			return false;
		if (sentMessages == null) {
			if (other.sentMessages != null)
				return false;
		} else if (!sentMessages.equals(other.sentMessages))
			return false;
		if (sexPref == null) {
			if (other.sexPref != null)
				return false;
		} else if (!sexPref.equals(other.sexPref))
			return false;
		if (userMatches == null) {
			if (other.userMatches != null)
				return false;
		} else if (!userMatches.equals(other.userMatches))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (usersId == null) {
			if (other.usersId != null)
				return false;
		} else if (!usersId.equals(other.usersId))
			return false;
		if (usertype == null) {
			if (other.usertype != null)
				return false;
		} else if (!usertype.equals(other.usertype))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Users [usersId=" + usersId + ", usertype=" + usertype + ", username=" + username + ", pass=" + pass
				+ ", firstname=" + firstname + ", lastname=" + lastname + ", score=" + score + ", age=" + age
				+ ", gender=" + gender + ", location=" + location + ", banned=" + banned + ", sexPref=" + sexPref
				+ ", agePref=" + agePref + ", userMatches=" + userMatches + ", sentMessages=" + sentMessages
				+ ", receivedMessages=" + receivedMessages + "]";
	}

}
