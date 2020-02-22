package dev.richardnewman.cbmetrics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.richardnewman.cbmetrics.entities.Referred;

public interface ReferredRepository extends JpaRepository<Referred, Integer> {

}
