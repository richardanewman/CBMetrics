package dev.richardnewman.cbmetrics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.richardnewman.cbmetrics.entities.ProductNotes;

public interface ProductNotesRepository extends JpaRepository<ProductNotes, Integer> {

}
