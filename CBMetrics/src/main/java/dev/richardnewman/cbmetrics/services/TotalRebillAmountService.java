package dev.richardnewman.cbmetrics.services;

import java.util.List;

import dev.richardnewman.cbmetrics.entities.TotalRebillAmount;

public interface TotalRebillAmountService {
	
	public List<TotalRebillAmount> index();
	
	public List<TotalRebillAmount> showByProductID(int pid); //Get All by Product ID (pid)
	
	public TotalRebillAmount show(int id);

}
