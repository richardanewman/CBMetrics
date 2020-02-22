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
@Table(name="total_rebill_amt")
public class TotalRebillAmount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	@Column(name="date_created")
	@CreationTimestamp
	private LocalDate dateCreated;
	
	@Column(name="total_rebill_value")
	private double totalRebillValue;

	public TotalRebillAmount(int id, Product product, LocalDate dateCreated, double totalRebillValue) {
		super();
		this.id = id;
		this.product = product;
		this.dateCreated = dateCreated;
		this.totalRebillValue = totalRebillValue;
	}

	public TotalRebillAmount() {
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

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public double getTotalRebillValue() {
		return totalRebillValue;
	}

	public void setTotalRebillValue(double totalRebillValue) {
		this.totalRebillValue = totalRebillValue;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TotalRebillAmount [id=");
		builder.append(id);
		builder.append(", product=");
		builder.append(product);
		builder.append(", dateCreated=");
		builder.append(dateCreated);
		builder.append(", totalRebillValue=");
		builder.append(totalRebillValue);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + id;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		long temp;
		temp = Double.doubleToLongBits(totalRebillValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		TotalRebillAmount other = (TotalRebillAmount) obj;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (id != other.id)
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (Double.doubleToLongBits(totalRebillValue) != Double.doubleToLongBits(other.totalRebillValue))
			return false;
		return true;
	}
	
	
	
}
