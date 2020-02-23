package dev.richardnewman.cbmetrics.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.richardnewman.cbmetrics.entities.TotalRebillAmount;

public interface TotalRebillAmountRepository extends JpaRepository<TotalRebillAmount, Integer> {
	
	public List<TotalRebillAmount> findByProduct_Id(int pid);

}
