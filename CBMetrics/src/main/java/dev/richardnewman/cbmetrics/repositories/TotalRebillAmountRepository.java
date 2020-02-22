package dev.richardnewman.cbmetrics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.richardnewman.cbmetrics.entities.TotalRebillAmount;

public interface TotalRebillAmountRepository extends JpaRepository<TotalRebillAmount, Integer> {

}
