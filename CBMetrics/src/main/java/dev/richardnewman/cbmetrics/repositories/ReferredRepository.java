package dev.richardnewman.cbmetrics.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.richardnewman.cbmetrics.entities.Referred;

public interface ReferredRepository extends JpaRepository<Referred, Integer> {

	public List<Referred> findByProduct_Id(int pid);
}
