package dev.richardnewman.cbmetrics.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.richardnewman.cbmetrics.entities.Commission;
import dev.richardnewman.cbmetrics.repositories.CommissionRepository;

@Service
public class CommissionServiceImpl implements CommissionService {
	
	@Autowired
	private CommissionRepository comRepo;

	@Override
	public List<Commission> index() {
		return comRepo.findAll();
	}

	@Override
	public List<Commission> showByProductID(int pid) {
		return comRepo.findByProduct_Id(pid);
	}

	@Override
	public Commission show(int id) {
		return comRepo.findById(id).get();
	}

}
