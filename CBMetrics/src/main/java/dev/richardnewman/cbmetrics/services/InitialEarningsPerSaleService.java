package dev.richardnewman.cbmetrics.services;

import java.util.List;

import dev.richardnewman.cbmetrics.entities.InitialEarningsPerSale;

public interface InitialEarningsPerSaleService {
	
public List<InitialEarningsPerSale> index();
	
	public List<InitialEarningsPerSale> showByProductID(int pid); //Get All by Product ID (pid)
	
	public InitialEarningsPerSale show(int id);

}
