package dev.richardnewman.cbmetrics.entities;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="dm")
public class DirectMessage {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="composer_id")
	private UserProfile composerProfile;
	
	@ManyToOne
	@JoinColumn(name="recipient_id")
	private UserProfile recipientProfile;
	
	private String message;
	
	@Column(name="date_posted")
	@CreationTimestamp
	private LocalDate datePosted;

	public DirectMessage(int id, UserProfile composerProfile, UserProfile recipientProfile, String message,
			LocalDate datePosted) {
		super();
		this.id = id;
		this.composerProfile = composerProfile;
		this.recipientProfile = recipientProfile;
		this.message = message;
		this.datePosted = datePosted;
	}

	public DirectMessage() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserProfile getComposerProfile() {
		return composerProfile;
	}

	public void setComposerProfile(UserProfile composerProfile) {
		this.composerProfile = composerProfile;
	}

	public UserProfile getRecipientProfile() {
		return recipientProfile;
	}

	public void setRecipientProfile(UserProfile recipientProfile) {
		this.recipientProfile = recipientProfile;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDate getDatePosted() {
		return datePosted;
	}

	public void setDatePosted(LocalDate datePosted) {
		this.datePosted = datePosted;
	}

	@Override
	public String toString() {
		return "DirectMessage [id=" + id + ", composerProfile=" + composerProfile + ", recipientProfile="
				+ recipientProfile + ", message=" + message + ", datePosted=" + datePosted + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((composerProfile == null) ? 0 : composerProfile.hashCode());
		result = prime * result + ((datePosted == null) ? 0 : datePosted.hashCode());
		result = prime * result + id;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((recipientProfile == null) ? 0 : recipientProfile.hashCode());
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
		DirectMessage other = (DirectMessage) obj;
		if (composerProfile == null) {
			if (other.composerProfile != null)
				return false;
		} else if (!composerProfile.equals(other.composerProfile))
			return false;
		if (datePosted == null) {
			if (other.datePosted != null)
				return false;
		} else if (!datePosted.equals(other.datePosted))
			return false;
		if (id != other.id)
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (recipientProfile == null) {
			if (other.recipientProfile != null)
				return false;
		} else if (!recipientProfile.equals(other.recipientProfile))
			return false;
		return true;
	}
	
	
}
