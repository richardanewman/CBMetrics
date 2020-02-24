package dev.richardnewman.cbmetrics.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.richardnewman.cbmetrics.entities.Product;
import dev.richardnewman.cbmetrics.services.ProductService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4288" })
public class ProductController {
	
	@Autowired
	private ProductService prodSvc;
	
	@GetMapping("products")
	private List<Product> index() {
		return prodSvc.index();
	}
	
	@GetMapping("product/{id}")
	private Product getProductById(@PathVariable int id) {
		return prodSvc.show(id);
	}
	
	@PostMapping("product")
	private Product createProduct(
			@RequestBody Product product,
			HttpServletRequest req,
			HttpServletResponse res) {
		
		try {
			product = prodSvc.create(product);
			res.setStatus(200);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(product.getId());
			res.addHeader("Location", url.toString());
			return product;
			
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			return null;
		}
	}
	
	@PutMapping("product/{id}")
	private Product updateProduct(
			@PathVariable int id,
			@RequestBody Product product,
			HttpServletResponse res) {
		
		try {
			product = prodSvc.update(id, product);
			res.setStatus(200);
			return product;
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			return null;
		}
	}
	
	@DeleteMapping("product/{id}")
	private boolean deleteProduct(
			@PathVariable int id,
			HttpServletResponse res) {
		
		try {
			boolean delete = prodSvc.destroy(id);
			res.setStatus(200);
			return delete;
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			return false;
		}
	}

}
