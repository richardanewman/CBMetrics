package dev.richardnewman.cbmetrics.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.richardnewman.cbmetrics.entities.InitialEarningsPerSale;
import dev.richardnewman.cbmetrics.repositories.InitialEarningsPerSaleRepository;

@Service
public class InitialEarningsPerSaleServiceImpl implements InitialEarningsPerSaleService {
	
	@Autowired
	private InitialEarningsPerSaleRepository ieRepo;

	@Override
	public List<InitialEarningsPerSale> index() {
		return ieRepo.findAll();
	}

	@Override
	public List<InitialEarningsPerSale> showByProductID(int pid) {
		return ieRepo.findByProduct_Id(pid);
	}

	@Override
	public InitialEarningsPerSale show(int id) {
		return ieRepo.findById(id).get();
	}

}
