package dev.richardnewman.cbmetrics.entities;

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
@Table(name="product_message")
public class ProductMessage {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="user_profile_id")
	private UserProfile userProfile;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	private String message;
	
	@ManyToOne
	@JoinColumn(name="replied_to_id")
	private UserProfile repliedToProfile;
	
	@Column(name="date_posted")
	@CreationTimestamp
	private LocalDate datePosted;

	public ProductMessage(int id, UserProfile userProfile, Product product, String message,
			UserProfile repliedToProfile, LocalDate datePosted) {
		super();
		this.id = id;
		this.userProfile = userProfile;
		this.product = product;
		this.message = message;
		this.repliedToProfile = repliedToProfile;
		this.datePosted = datePosted;
	}

	public ProductMessage() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserProfile getRepliedToProfile() {
		return repliedToProfile;
	}

	public void setRepliedToProfile(UserProfile repliedToProfile) {
		this.repliedToProfile = repliedToProfile;
	}

	public LocalDate getDatePosted() {
		return datePosted;
	}

	public void setDatePosted(LocalDate datePosted) {
		this.datePosted = datePosted;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductMessage [id=");
		builder.append(id);
		builder.append(", userProfile=");
		builder.append(userProfile);
		builder.append(", product=");
		builder.append(product);
		builder.append(", message=");
		builder.append(message);
		builder.append(", repliedToProfile=");
		builder.append(repliedToProfile);
		builder.append(", datePosted=");
		builder.append(datePosted);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datePosted == null) ? 0 : datePosted.hashCode());
		result = prime * result + id;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((repliedToProfile == null) ? 0 : repliedToProfile.hashCode());
		result = prime * result + ((userProfile == null) ? 0 : userProfile.hashCode());
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
		ProductMessage other = (ProductMessage) obj;
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
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (repliedToProfile == null) {
			if (other.repliedToProfile != null)
				return false;
		} else if (!repliedToProfile.equals(other.repliedToProfile))
			return false;
		if (userProfile == null) {
			if (other.userProfile != null)
				return false;
		} else if (!userProfile.equals(other.userProfile))
			return false;
		return true;
	}
	
	

}
