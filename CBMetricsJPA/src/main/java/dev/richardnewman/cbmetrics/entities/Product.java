package dev.richardnewman.cbmetrics.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="cb_id")
	private String cbID;
	
	@Column(name="popularity_rank")
	private int popularityRank;
	
	private String title;
	
	private String description;
	
	@Column(name="has_recurring_products")
	private boolean hasRecurringProducts;
	
	private double gravity;
	
	@Column(name="percent_per_sale")
	private double percentPerSale;
	
	@Column(name="percent_per_rebill")
	private double percentPerRebill;
	
	@Column(name="average_earnings_per_sale")
	private double avgEarningsPerSale;
	
	@Column(name="initial_earnings_per_sale")
	private double initialEarningsPerSale;
	
	@Column(name="total_rebill_amt")
	private double totalRebillAmt;
	
	private double referred;
	
	private int commission;
	
	@Column(name="active_date")
	private LocalDate activeDate;


	public Product(int id, String cbID, int popularityRank, String title, String description,
			boolean hasRecurringProducts, double gravity, double percentPerSale, double percentPerRebill,
			double avgEarningsPerSale, double initialEarningsPerSale, double totalRebillAmt, double referred,
			int commission, LocalDate activeDate) {
		super();
		this.id = id;
		this.cbID = cbID;
		this.popularityRank = popularityRank;
		this.title = title;
		this.description = description;
		this.hasRecurringProducts = hasRecurringProducts;
		this.gravity = gravity;
		this.percentPerSale = percentPerSale;
		this.percentPerRebill = percentPerRebill;
		this.avgEarningsPerSale = avgEarningsPerSale;
		this.initialEarningsPerSale = initialEarningsPerSale;
		this.totalRebillAmt = totalRebillAmt;
		this.referred = referred;
		this.commission = commission;
		this.activeDate = activeDate;
	}
	
	public Product() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCbID() {
		return cbID;
	}

	public void setCbID(String cbID) {
		this.cbID = cbID;
	}

	public int getPopularityRank() {
		return popularityRank;
	}

	public void setPopularityRank(int popularityRank) {
		this.popularityRank = popularityRank;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isHasRecurringProducts() {
		return hasRecurringProducts;
	}

	public void setHasRecurringProducts(boolean hasRecurringProducts) {
		this.hasRecurringProducts = hasRecurringProducts;
	}

	public double getGravity() {
		return gravity;
	}

	public void setGravity(double gravity) {
		this.gravity = gravity;
	}

	public double getPercentPerSale() {
		return percentPerSale;
	}

	public void setPercentPerSale(double percentPerSale) {
		this.percentPerSale = percentPerSale;
	}

	public double getPercentPerRebill() {
		return percentPerRebill;
	}

	public void setPercentPerRebill(double percentPerRebill) {
		this.percentPerRebill = percentPerRebill;
	}

	public double getAvgEarningsPerSale() {
		return avgEarningsPerSale;
	}

	public void setAvgEarningsPerSale(double avgEarningsPerSale) {
		this.avgEarningsPerSale = avgEarningsPerSale;
	}

	public double getInitialEarningsPerSale() {
		return initialEarningsPerSale;
	}

	public void setInitialEarningsPerSale(double initialEarningsPerSale) {
		this.initialEarningsPerSale = initialEarningsPerSale;
	}

	public double getTotalRebillAmt() {
		return totalRebillAmt;
	}

	public void setTotalRebillAmt(double totalRebillAmt) {
		this.totalRebillAmt = totalRebillAmt;
	}

	public double getReferred() {
		return referred;
	}

	public void setReferred(double referred) {
		this.referred = referred;
	}

	public int getCommission() {
		return commission;
	}

	public void setCommission(int commission) {
		this.commission = commission;
	}

	public LocalDate getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(LocalDate activeDate) {
		this.activeDate = activeDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [id=");
		builder.append(id);
		builder.append(", cbID=");
		builder.append(cbID);
		builder.append(", popularityRank=");
		builder.append(popularityRank);
		builder.append(", title=");
		builder.append(title);
		builder.append(", description=");
		builder.append(description);
		builder.append(", hasRecurringProducts=");
		builder.append(hasRecurringProducts);
		builder.append(", gravity=");
		builder.append(gravity);
		builder.append(", percentPerSale=");
		builder.append(percentPerSale);
		builder.append(", percentPerRebill=");
		builder.append(percentPerRebill);
		builder.append(", avgEarningsPerSale=");
		builder.append(avgEarningsPerSale);
		builder.append(", initialEarningsPerSale=");
		builder.append(initialEarningsPerSale);
		builder.append(", totalRebillAmt=");
		builder.append(totalRebillAmt);
		builder.append(", referred=");
		builder.append(referred);
		builder.append(", commission=");
		builder.append(commission);
		builder.append(", activeDate=");
		builder.append(activeDate);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activeDate == null) ? 0 : activeDate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(avgEarningsPerSale);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((cbID == null) ? 0 : cbID.hashCode());
		result = prime * result + commission;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		temp = Double.doubleToLongBits(gravity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (hasRecurringProducts ? 1231 : 1237);
		result = prime * result + id;
		temp = Double.doubleToLongBits(initialEarningsPerSale);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(percentPerRebill);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(percentPerSale);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + popularityRank;
		temp = Double.doubleToLongBits(referred);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		temp = Double.doubleToLongBits(totalRebillAmt);
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
		Product other = (Product) obj;
		if (activeDate == null) {
			if (other.activeDate != null)
				return false;
		} else if (!activeDate.equals(other.activeDate))
			return false;
		if (Double.doubleToLongBits(avgEarningsPerSale) != Double.doubleToLongBits(other.avgEarningsPerSale))
			return false;
		if (cbID == null) {
			if (other.cbID != null)
				return false;
		} else if (!cbID.equals(other.cbID))
			return false;
		if (commission != other.commission)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (Double.doubleToLongBits(gravity) != Double.doubleToLongBits(other.gravity))
			return false;
		if (hasRecurringProducts != other.hasRecurringProducts)
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(initialEarningsPerSale) != Double.doubleToLongBits(other.initialEarningsPerSale))
			return false;
		if (Double.doubleToLongBits(percentPerRebill) != Double.doubleToLongBits(other.percentPerRebill))
			return false;
		if (Double.doubleToLongBits(percentPerSale) != Double.doubleToLongBits(other.percentPerSale))
			return false;
		if (popularityRank != other.popularityRank)
			return false;
		if (Double.doubleToLongBits(referred) != Double.doubleToLongBits(other.referred))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (Double.doubleToLongBits(totalRebillAmt) != Double.doubleToLongBits(other.totalRebillAmt))
			return false;
		return true;
	}
	
	
	
	

}
