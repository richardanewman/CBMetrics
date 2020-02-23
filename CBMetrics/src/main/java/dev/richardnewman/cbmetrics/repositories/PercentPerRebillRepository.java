package dev.richardnewman.cbmetrics.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.richardnewman.cbmetrics.entities.PercentPerRebill;

public interface PercentPerRebillRepository extends JpaRepository<PercentPerRebill, Integer> {
	
	public List<PercentPerRebill> findByProduct_Id(int pid);

}
