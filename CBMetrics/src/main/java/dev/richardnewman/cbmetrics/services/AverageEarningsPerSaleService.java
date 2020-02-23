package dev.richardnewman.cbmetrics.services;

import java.util.List;

import dev.richardnewman.cbmetrics.entities.AverageEarningsPerSale;

public interface AverageEarningsPerSaleService {
	
	public List<AverageEarningsPerSale> index();
	
	public List<AverageEarningsPerSale> showByProductID(int pid); //Get by Product ID (pid)
	
	public AverageEarningsPerSale show(int id);
	
//	public AverageEarningsPerSale create(AverageEarningsPerSale aeps);
//	
//	public AverageEarningsPerSale update(int id, AverageEarningsPerSale aeps);
//	
//	public AverageEarningsPerSale delete(int id, AverageEarningsPerSale aeps);

	

}
