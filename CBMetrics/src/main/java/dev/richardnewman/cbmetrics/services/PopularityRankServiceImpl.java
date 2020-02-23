package dev.richardnewman.cbmetrics.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.richardnewman.cbmetrics.entities.PopularityRank;
import dev.richardnewman.cbmetrics.repositories.PopularityRankRepository;

@Service
public class PopularityRankServiceImpl implements PopularityRankService {
	
	@Autowired
	private PopularityRankRepository popRepo;

	@Override
	public List<PopularityRank> index() {
		return popRepo.findAll();
	}

	@Override
	public List<PopularityRank> showByProductID(int pid) {
		return popRepo.findByProduct_Id(pid);
	}

	@Override
	public PopularityRank show(int id) {
		return popRepo.findById(id).get();
	}

}
