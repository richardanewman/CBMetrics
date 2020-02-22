package dev.richardnewman.cbmetrics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.richardnewman.cbmetrics.entities.PopularityRank;

public interface PopularityRankRepository extends JpaRepository<PopularityRank, Integer> {

}
