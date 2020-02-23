package dev.richardnewman.cbmetrics.services;

import java.util.List;

import dev.richardnewman.cbmetrics.entities.PercentPerSale;

public interface PercentPerSaleService {
	
	public List<PercentPerSale> index();
	
	public List<PercentPerSale> showByProductID(int pid); //Get All by Product ID (pid)
	
	public PercentPerSale show(int id);

}
