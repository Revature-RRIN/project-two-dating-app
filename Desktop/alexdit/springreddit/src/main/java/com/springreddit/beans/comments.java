package com.springreddit.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="comments")
public class comments implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="content")
	private String content;
	@Column(name="id")
	private int cDoots;
	@OneToMany
	@JoinColumn(name="id")
	private users cUser;

	
	
	public comments(int id, String content, int cDoots, users cUser) {
		super();
		this.id = id;
		this.content = content;
		this.cDoots = cDoots;
		this.cUser = cUser;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getcDoots() {
		return cDoots;
	}

	public void setcDoots(int cDoots) {
		this.cDoots = cDoots;
	}

	public users getcUser() {
		return cUser;
	}

	public void setcUser(users cUser) {
		this.cUser = cUser;
	}
	
	
}
