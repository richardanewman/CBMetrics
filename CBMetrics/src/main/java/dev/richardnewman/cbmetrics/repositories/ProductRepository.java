package dev.richardnewman.cbmetrics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.richardnewman.cbmetrics.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
