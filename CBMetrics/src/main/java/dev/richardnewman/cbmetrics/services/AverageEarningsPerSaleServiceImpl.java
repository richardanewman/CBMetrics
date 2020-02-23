package dev.richardnewman.cbmetrics.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.richardnewman.cbmetrics.entities.AverageEarningsPerSale;
import dev.richardnewman.cbmetrics.repositories.AverageEarningsPerSaleRepository;

@Service
public class AverageEarningsPerSaleServiceImpl implements AverageEarningsPerSaleService {
	
	@Autowired
	private AverageEarningsPerSaleRepository aeRepo;

	@Override
	public List<AverageEarningsPerSale> index() {
		return aeRepo.findAll();
	}

	@Override
	public List<AverageEarningsPerSale> showByProductID(int pid) {
		return aeRepo.findByProduct_Id(pid);
	}
	
	@Override
	public AverageEarningsPerSale show(int id) {
		return aeRepo.findById(id).get();
	}

	
	
	

}
