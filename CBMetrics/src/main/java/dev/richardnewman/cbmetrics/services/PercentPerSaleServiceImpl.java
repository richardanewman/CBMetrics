package dev.richardnewman.cbmetrics.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.richardnewman.cbmetrics.entities.PercentPerSale;
import dev.richardnewman.cbmetrics.repositories.PercentPerSaleRepository;

@Service
public class PercentPerSaleServiceImpl implements PercentPerSaleService {
	
	@Autowired
	private PercentPerSaleRepository ppsRepo;

	@Override
	public List<PercentPerSale> index() {
		return ppsRepo.findAll();
	}

	@Override
	public List<PercentPerSale> showByProductID(int pid) {
		return ppsRepo.findByProduct_Id(pid);
	}

	@Override
	public PercentPerSale show(int id) {
		return ppsRepo.findById(id).get();
	}

}
