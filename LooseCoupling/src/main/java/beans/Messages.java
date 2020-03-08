package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@Column(name = "sender_id")
	private Integer senderId;
	@Column(name = "receiver_id")
	private Integer receiverId;
	@Column
	private String remark;

	public Messages() {
		super();
	}

	
	public Messages(Integer messagesId) {
		super();
		this.messagesId = messagesId;
	}


	public Messages(Integer messagesId, Integer senderId, Integer receiverId, String remark) {
		super();
		this.messagesId = messagesId;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.remark = remark;
	}

	
	public Integer getMessagesId() {
		return messagesId;
	}

	public void setMessagesId(Integer messagesId) {
		this.messagesId = messagesId;
	}

	public Integer getSenderId() {
		return senderId;
	}

	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}

	public Integer getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Integer receiverId) {
		this.receiverId = receiverId;
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
		result = prime * result + ((receiverId == null) ? 0 : receiverId.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((senderId == null) ? 0 : senderId.hashCode());
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
		if (receiverId == null) {
			if (other.receiverId != null)
				return false;
		} else if (!receiverId.equals(other.receiverId))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (senderId == null) {
			if (other.senderId != null)
				return false;
		} else if (!senderId.equals(other.senderId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Messages [messagesId=" + messagesId + ", senderId=" + senderId + ", receiverId=" + receiverId
				+ ", remark=" + remark + "]";
	}

}
