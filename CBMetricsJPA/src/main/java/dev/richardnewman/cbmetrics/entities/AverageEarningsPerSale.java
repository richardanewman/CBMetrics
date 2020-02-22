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
@Table(name="average_earnings_per_sale")
public class AverageEarningsPerSale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	@Column(name="date_created")
	@CreationTimestamp
	private LocalDate dateCreated;
	
	@Column(name="avg_earnings_value")
	private double avgEarningsValue;

	public AverageEarningsPerSale(int id, Product product, LocalDate dateCreated, double avgEarningsValue) {
		super();
		this.id = id;
		this.product = product;
		this.dateCreated = dateCreated;
		this.avgEarningsValue = avgEarningsValue;
	}

	public AverageEarningsPerSale() {
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

	public double getAvgEarningsValue() {
		return avgEarningsValue;
	}

	public void setAvgEarningsValue(double avgEarningsValue) {
		this.avgEarningsValue = avgEarningsValue;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AverageEarningsPerSale [id=");
		builder.append(id);
		builder.append(", product=");
		builder.append(product);
		builder.append(", dateCreated=");
		builder.append(dateCreated);
		builder.append(", avgEarningsValue=");
		builder.append(avgEarningsValue);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(avgEarningsValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
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
		AverageEarningsPerSale other = (AverageEarningsPerSale) obj;
		if (Double.doubleToLongBits(avgEarningsValue) != Double.doubleToLongBits(other.avgEarningsValue))
			return false;
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
		return true;
	}
	
	

}
