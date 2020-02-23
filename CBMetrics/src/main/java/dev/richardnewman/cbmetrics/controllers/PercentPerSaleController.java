package dev.richardnewman.cbmetrics.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.richardnewman.cbmetrics.entities.PercentPerSale;
import dev.richardnewman.cbmetrics.services.PercentPerSaleService;

@RestController
@RequestMapping("api")
public class PercentPerSaleController {
	
	@Autowired
	private PercentPerSaleService ppsSvc;
	
	@GetMapping("sale")
	private List<PercentPerSale> index(){
		return ppsSvc.index();
	}
	
	@GetMapping("sale/product/{pid}")
	private List<PercentPerSale> showAllByProductId(@PathVariable int pid) {
		return ppsSvc.showByProductID(pid);
	}
	
	@GetMapping("sale/{id}")
	private PercentPerSale show(@PathVariable int id) {
		return ppsSvc.show(id);
	}
	
	
	

}
