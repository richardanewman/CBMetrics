package dev.richardnewman.cbmetrics.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Commission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	@JsonIgnoreProperties({"popularityRank", 
		"title",
        "description",
        "hasRecurringProducts",
        "gravity",
        "percentPerSale",
        "percentPerRebill",
        "avgEarningsPerSale",
        "initialEarningsPerSale",
        "totalRebillAmt",
        "referred",
        "commission",
        "activeDate",
        "categories"})
	private Product product;
	
	@Column(name="date_changed")
	@CreationTimestamp
	private LocalDate dateChanged;
	
	@Column(name="commission_value")
	private int commissionValue;

	public Commission(int id, Product product, LocalDate dateChanged, int commissionValue) {
		super();
		this.id = id;
		this.product = product;
		this.dateChanged = dateChanged;
		this.commissionValue = commissionValue;
	}

	public Commission() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public LocalDate getDateChanged() {
		return dateChanged;
	}

	public void setDateChanged(LocalDate dateChanged) {
		this.dateChanged = dateChanged;
	}

	public int getCommissionValue() {
		return commissionValue;
	}

	public void setCommissionValue(int commissionValue) {
		this.commissionValue = commissionValue;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Commission [id=");
		builder.append(id);
		builder.append(", product=");
		builder.append(product);
		builder.append(", dateChanged=");
		builder.append(dateChanged);
		builder.append(", commissionValue=");
		builder.append(commissionValue);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + commissionValue;
		result = prime * result + ((dateChanged == null) ? 0 : dateChanged.hashCode());
		result = prime * result + id;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		Commission other = (Commission) obj;
		if (commissionValue != other.commissionValue)
			return false;
		if (dateChanged == null) {
			if (other.dateChanged != null)
				return false;
		} else if (!dateChanged.equals(other.dateChanged))
			return false;
		if (id != other.id)
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}
	
	

}
