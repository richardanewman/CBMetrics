package dev.richardnewman.cbmetrics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.richardnewman.cbmetrics.entities.Gravity;

public interface GravityRepository extends JpaRepository<Gravity, Integer> {

}
