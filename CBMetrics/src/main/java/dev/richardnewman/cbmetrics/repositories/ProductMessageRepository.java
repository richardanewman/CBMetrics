package dev.richardnewman.cbmetrics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.richardnewman.cbmetrics.entities.ProductMessage;

public interface ProductMessageRepository extends JpaRepository<ProductMessage, Integer> {

}
