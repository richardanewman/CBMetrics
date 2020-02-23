package dev.richardnewman.cbmetrics.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.richardnewman.cbmetrics.entities.Referred;
import dev.richardnewman.cbmetrics.repositories.ReferredRepository;

@Service
public class ReferredServiceImpl implements ReferredService {
	
	@Autowired
	private ReferredRepository refRepo;

	@Override
	public List<Referred> index() {
		return refRepo.findAll();
	}

	@Override
	public List<Referred> showByProductID(int pid) {
		return refRepo.findByProduct_Id(pid);
	}

	@Override
	public Referred show(int id) {
		return refRepo.findById(id).get();
	}

}
