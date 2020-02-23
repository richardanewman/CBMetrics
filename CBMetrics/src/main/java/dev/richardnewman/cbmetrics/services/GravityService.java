package dev.richardnewman.cbmetrics.services;

import java.util.List;

import dev.richardnewman.cbmetrics.entities.Gravity;

public interface GravityService {
	
	public List<Gravity> index();
	
	public List<Gravity> showByProductID(int pid); //Get All by Product ID (pid)
	
	public Gravity show(int id);

}
