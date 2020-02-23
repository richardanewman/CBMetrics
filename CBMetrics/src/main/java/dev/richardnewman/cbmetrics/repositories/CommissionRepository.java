package dev.richardnewman.cbmetrics.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.richardnewman.cbmetrics.entities.Commission;

public interface CommissionRepository extends JpaRepository<Commission, Integer> {
	
	public List<Commission> findByProduct_Id(int pid);

}
