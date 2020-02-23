package dev.richardnewman.cbmetrics.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.richardnewman.cbmetrics.entities.PopularityRank;

public interface PopularityRankRepository extends JpaRepository<PopularityRank, Integer> {
	
	public List<PopularityRank> findByProduct_Id(int pid);

}
