package dev.richardnewman.cbmetrics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.richardnewman.cbmetrics.entities.AverageEarningsPerSale;

public interface AverageEarningsPerSaleRepository extends JpaRepository<AverageEarningsPerSale, Integer> {

}
