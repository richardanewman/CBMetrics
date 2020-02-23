package dev.richardnewman.cbmetrics.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.richardnewman.cbmetrics.entities.Gravity;
import dev.richardnewman.cbmetrics.repositories.GravityRepository;

@Service
public class GravityServiceImpl implements GravityService {
	
	@Autowired
	private GravityRepository gRepo;

	@Override
	public List<Gravity> index() {
		return gRepo.findAll();
	}

	@Override
	public List<Gravity> showByProductID(int pid) {
		return gRepo.findByProduct_Id(pid);
	}

	@Override
	public Gravity show(int id) {
		return gRepo.findById(id).get();
	}

}
