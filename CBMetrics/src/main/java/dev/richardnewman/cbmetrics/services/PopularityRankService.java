package dev.richardnewman.cbmetrics.services;

import java.util.List;

import dev.richardnewman.cbmetrics.entities.PopularityRank;

public interface PopularityRankService {
	
	public List<PopularityRank> index();
	
	public List<PopularityRank> showByProductID(int pid); //Get All by Product ID (pid)
	
	public PopularityRank show(int id);

}
