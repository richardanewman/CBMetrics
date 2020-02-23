package dev.richardnewman.cbmetrics.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.richardnewman.cbmetrics.entities.AverageEarningsPerSale;

public interface AverageEarningsPerSaleRepository extends JpaRepository<AverageEarningsPerSale, Integer> {
	
	public List<AverageEarningsPerSale> findByProduct_Id(int pid);

}
