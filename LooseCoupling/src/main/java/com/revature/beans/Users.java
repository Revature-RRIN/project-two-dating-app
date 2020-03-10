package com.revature.beans;

import java.sql.Blob;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table
//Do we need to classify (name="" field)??
public class Users {
	@Id
	@Column (name="users_id")
	@SequenceGenerator (name="users", sequenceName="users_seq", allocationSize = 1)
	@GeneratedValue(generator="users", strategy=GenerationType.SEQUENCE)
	private Integer usersId;
	@Column
	private Integer usertype;
	@Column
	private String username;
	@Column
	private String pass;
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	//DON'T GO BLOB ROUTE! S3 INTEGRATION
	private Blob profilepic;
	@Column
	private Integer score;
	@Column
	private Integer age;
	@Column
	private Integer gender;
	@Column
	private String location;
	@Column
	private String banned;
	@ManyToMany (fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable (name="MATCH_USER",
		joinColumns=@JoinColumn(name="users_id"),
		inverseJoinColumns=@JoinColumn(name="matches_id"))
	private Set<Matches> userMatches;
	@ManyToMany (fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable (name="MESSAGES_USER",
		joinColumns=@JoinColumn(name="users_id"),
		inverseJoinColumns=@JoinColumn(name="messages_id"))
	private Set<Messages> userMessages;
	
	//Need @OneToMany mapping for answers (as a set)?? Or does the cumulative "score" field suffice??
		//...Will we ever need to retrieve answers individually??
	
	//Need to remove recursive elements (userMatches and userMessages) 
		//from .hascode(), .equals(), and .toString()
	
	
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
			Blob profilepic, Integer score, Integer age, Integer gender, String location, String banned, 
			Set<Matches> userMatches, Set<Messages> userMessages) {
		super();
		this.usersId = usersId;
		this.usertype = usertype;
		this.username = username;
		this.pass = pass;
		this.firstname = firstname;
		this.lastname = lastname;
		this.profilepic = profilepic;
		this.score = score;
		this.age = age;
		this.gender = gender;
		this.location = location;
		this.banned = banned;
		this.userMatches = userMatches;
		this.userMessages = userMessages;
	}

	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer UsersId) {
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

	public Blob getProfilepic() {
		return profilepic;
	}

	public void setProfilepic(Blob profilepic) {
		this.profilepic = profilepic;
	}

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

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
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

	public Set<Messages> getUserMessages() {
		return userMessages;
	}

	public void setUserMessages(Set<Messages> userMessages) {
		this.userMessages = userMessages;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((banned == null) ? 0 : banned.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((score == null) ? 0 : score.hashCode());
//		result = prime * result + ((userMatches == null) ? 0 : userMatches.hashCode());
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
		if (score == null) {
			if (other.score != null)
				return false;
		} else if (!score.equals(other.score))
			return false;
//		if (userMatches == null) {
//			if (other.userMatches != null)
//				return false;
//		} else if (!userMatches.equals(other.userMatches))
//			return false;
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
				+ ", gender=" + gender + ", location=" + location + ", banned=" + banned + "]";
	}
	
}
