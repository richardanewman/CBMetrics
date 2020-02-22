package dev.richardnewman.cbmetrics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.richardnewman.cbmetrics.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
