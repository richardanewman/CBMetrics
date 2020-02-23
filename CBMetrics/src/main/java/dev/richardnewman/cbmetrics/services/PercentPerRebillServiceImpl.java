package dev.richardnewman.cbmetrics.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.richardnewman.cbmetrics.entities.PercentPerRebill;
import dev.richardnewman.cbmetrics.repositories.PercentPerRebillRepository;

@Service
public class PercentPerRebillServiceImpl implements PercentPerRebillService {
	
	@Autowired
	private PercentPerRebillRepository prRepo;

	@Override
	public List<PercentPerRebill> index() {
		return prRepo.findAll();
	}

	@Override
	public List<PercentPerRebill> showByProductID(int pid) {
		return prRepo.findByProduct_Id(pid);
	}

	@Override
	public PercentPerRebill show(int id) {
		return prRepo.findById(id).get();
	}

}
