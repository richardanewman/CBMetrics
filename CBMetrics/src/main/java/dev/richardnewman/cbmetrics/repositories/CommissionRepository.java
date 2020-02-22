package dev.richardnewman.cbmetrics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.richardnewman.cbmetrics.entities.Commission;

public interface CommissionRepository extends JpaRepository<Commission, Integer> {

}
