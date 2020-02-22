package dev.richardnewman.cbmetrics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.richardnewman.cbmetrics.entities.PercentPerSale;

public interface PercentPerSaleRepository extends JpaRepository<PercentPerSale, Integer> {

}
