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
@Table(name="percent_per_rebill")
public class PercentPerRebill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	@Column(name="date_changed")
	@CreationTimestamp
	private LocalDate dateChanged;
	
	@Column(name="percent_rebill_value")
	private double rebillValue;

	public PercentPerRebill(int id, Product product, LocalDate dateChanged, double rebillValue) {
		super();
		this.id = id;
		this.product = product;
		this.dateChanged = dateChanged;
		this.rebillValue = rebillValue;
	}

	public PercentPerRebill() {
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

	public double getRebillValue() {
		return rebillValue;
	}

	public void setRebillValue(double rebillValue) {
		this.rebillValue = rebillValue;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PercentPerRebill [id=");
		builder.append(id);
		builder.append(", product=");
		builder.append(product);
		builder.append(", dateChanged=");
		builder.append(dateChanged);
		builder.append(", rebillValue=");
		builder.append(rebillValue);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateChanged == null) ? 0 : dateChanged.hashCode());
		result = prime * result + id;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		long temp;
		temp = Double.doubleToLongBits(rebillValue);
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
		PercentPerRebill other = (PercentPerRebill) obj;
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
		if (Double.doubleToLongBits(rebillValue) != Double.doubleToLongBits(other.rebillValue))
			return false;
		return true;
	}
	
	
	
	
}
