package dev.richardnewman.cbmetrics.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.richardnewman.cbmetrics.entities.Gravity;

public interface GravityRepository extends JpaRepository<Gravity, Integer> {
	
	public List<Gravity> findByProduct_Id(int pid);

}
