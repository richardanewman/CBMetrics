package dev.richardnewman.cbmetrics.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.richardnewman.cbmetrics.entities.InitialEarningsPerSale;

public interface InitialEarningsPerSaleRepository extends JpaRepository<InitialEarningsPerSale, Integer> {
	
	public List<InitialEarningsPerSale> findByProduct_Id(int pid);

}
