package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Messages {
	@Id
	@Column(name = "messages_id")
	@SequenceGenerator(name = "messages", sequenceName = "messages_seq", allocationSize = 1)
	@GeneratedValue(generator = "messages", strategy = GenerationType.SEQUENCE)
	private Integer messagesId;
	@OneToOne
	@JoinColumn (name="sender_id")
	private Users sender;
	@OneToOne
	@JoinColumn (name="receiver_id")
	private Users receiver;
	@Column
	private String remark;
	
	//NEEDS two OneToOne mappings for each sender and receiver

	
	
	public Messages() {
		super();
	}

	public Messages(Integer messagesId) {
		super();
		this.messagesId = messagesId;
	}


	public Messages(Integer messagesId, Users sender, Users receiver, String remark) {
		super();
		this.messagesId = messagesId;
		this.sender = sender;
		this.receiver = receiver;
		this.remark = remark;
	}

	
	public Integer getMessagesId() {
		return messagesId;
	}

	public void setMessagesId(Integer messagesId) {
		this.messagesId = messagesId;
	}

	public Users getSender() {
		return sender;
	}

	public void setSenderId(Users sender) {
		this.sender = sender;
	}

	public Users getReceiver() {
		return receiver;
	}

	public void setReceiver(Users receiver) {
		this.receiver = receiver;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((messagesId == null) ? 0 : messagesId.hashCode());
		result = prime * result + ((receiver == null) ? 0 : receiver.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((sender == null) ? 0 : sender.hashCode());
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
		Messages other = (Messages) obj;
		if (messagesId == null) {
			if (other.messagesId != null)
				return false;
		} else if (!messagesId.equals(other.messagesId))
			return false;
		if (receiver == null) {
			if (other.receiver != null)
				return false;
		} else if (!receiver.equals(other.receiver))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (sender == null) {
			if (other.sender != null)
				return false;
		} else if (!sender.equals(other.sender))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Messages [messagesId=" + messagesId + ", senderId=" + sender + ", receiverId=" + receiver
				+ ", remark=" + remark + "]";
	}

}
