package com.springreddit.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="posts")
public class posts implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="pTitle")
	private String pTitle;
	@Column(name="pLink")
	private String pLink;
	@Column(name="pDoots")
	private int pDoots;
	@ManyToOne
	@JoinColumn(name="id")
    private users pUser;
	@OneToMany
	@JoinColumn(name="id")
	private comments pComments;
	public posts(int id, String pTitle, String pLink, int pDoots, users pUser, comments pComments) {
		super();
		this.id = id;
		this.pTitle = pTitle;
		this.pLink = pLink;
		this.pDoots = pDoots;
		this.pUser = pUser;
		this.pComments = pComments;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getpTitle() {
		return pTitle;
	}
	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}
	public String getpLink() {
		return pLink;
	}
	public void setpLink(String pLink) {
		this.pLink = pLink;
	}
	public int getpDoots() {
		return pDoots;
	}
	public void setpDoots(int pDoots) {
		this.pDoots = pDoots;
	}
	public users getpUser() {
		return pUser;
	}
	public void setpUser(users pUser) {
		this.pUser = pUser;
	}
	public comments getpComments() {
		return pComments;
	}
	public void setpComments(comments pComments) {
		this.pComments = pComments;
	}
	
	
	

}
