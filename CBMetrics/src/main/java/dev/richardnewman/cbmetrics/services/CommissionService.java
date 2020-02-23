package dev.richardnewman.cbmetrics.services;

import java.util.List;

import dev.richardnewman.cbmetrics.entities.Commission;

public interface CommissionService {
	
public List<Commission> index();
	
	public List<Commission> showByProductID(int pid); //Get All by Product ID (pid)
	
	public Commission show(int id);

}
