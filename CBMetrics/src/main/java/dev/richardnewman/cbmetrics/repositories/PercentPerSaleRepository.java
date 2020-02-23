package dev.richardnewman.cbmetrics.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.richardnewman.cbmetrics.entities.PercentPerSale;

public interface PercentPerSaleRepository extends JpaRepository<PercentPerSale, Integer> {
	
	public List<PercentPerSale> findByProduct_Id(int pid);

}
