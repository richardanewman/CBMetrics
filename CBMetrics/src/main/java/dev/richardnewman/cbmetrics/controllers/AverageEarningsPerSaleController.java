package dev.richardnewman.cbmetrics.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.richardnewman.cbmetrics.entities.AverageEarningsPerSale;
import dev.richardnewman.cbmetrics.services.AverageEarningsPerSaleService;

@RestController
@RequestMapping("api")
public class AverageEarningsPerSaleController {
	
	@Autowired
	private AverageEarningsPerSaleService aeSvc;
	
	@GetMapping("aeps")
	private List<AverageEarningsPerSale> index(){
		return aeSvc.index();
	}
	
	@GetMapping("aeps/product/{pid}")
	private List<AverageEarningsPerSale> showAllByProductId(@PathVariable int pid) {
		return aeSvc.showByProductID(pid);
	}
	
	@GetMapping("aeps/{id}")
	private AverageEarningsPerSale show(@PathVariable int id) {
		return aeSvc.show(id);
	}
	
	
	

}
