package dev.richardnewman.cbmetrics.services;

import java.util.List;

import dev.richardnewman.cbmetrics.entities.PercentPerRebill;

public interface PercentPerRebillService {
	
	public List<PercentPerRebill> index();
	
	public List<PercentPerRebill> showByProductID(int pid); //Get All by Product ID (pid)
	
	public PercentPerRebill show(int id);

}
