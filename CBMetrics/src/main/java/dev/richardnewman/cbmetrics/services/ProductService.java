package dev.richardnewman.cbmetrics.services;

import java.util.List;

import dev.richardnewman.cbmetrics.entities.Product;

public interface ProductService {
	
	public List<Product> index();
	
	public Product show(int id);
	
	public Product create(Product product);
	
	public Product update(int id, Product product);
	
	public boolean destroy(int id);

}
