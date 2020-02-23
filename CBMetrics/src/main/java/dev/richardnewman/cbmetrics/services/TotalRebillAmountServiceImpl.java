package dev.richardnewman.cbmetrics.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.richardnewman.cbmetrics.entities.TotalRebillAmount;
import dev.richardnewman.cbmetrics.repositories.TotalRebillAmountRepository;

@Service
public class TotalRebillAmountServiceImpl implements TotalRebillAmountService {
	
	@Autowired
	private TotalRebillAmountRepository traRepo;

	@Override
	public List<TotalRebillAmount> index() {
		return traRepo.findAll();
	}

	@Override
	public List<TotalRebillAmount> showByProductID(int pid) {
		return traRepo.findByProduct_Id(pid);
	}

	@Override
	public TotalRebillAmount show(int id) {
		return traRepo.findById(id).get();
	}

}
