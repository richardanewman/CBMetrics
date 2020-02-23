package dev.richardnewman.cbmetrics.services;

import java.util.List;

import dev.richardnewman.cbmetrics.entities.Referred;

public interface ReferredService {
	
	public List<Referred> index();
	
	public List<Referred> showByProductID(int pid); //Get All by Product ID (pid)
	
	public Referred show(int id);

}
