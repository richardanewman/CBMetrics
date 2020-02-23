package dev.richardnewman.cbmetrics.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.richardnewman.cbmetrics.entities.InitialEarningsPerSale;
import dev.richardnewman.cbmetrics.services.InitialEarningsPerSaleService;

@RestController
@RequestMapping("api")
public class InitialEarningsPerSaleController {
	
	@Autowired
	private InitialEarningsPerSaleService ieSvc;
	
	@GetMapping("ieps")
	private List<InitialEarningsPerSale> index(){
		return ieSvc.index();
	}
	
	@GetMapping("ieps/product/{pid}")
	private List<InitialEarningsPerSale> showAllByProductId(@PathVariable int pid) {
		return ieSvc.showByProductID(pid);
	}
	
	@GetMapping("ieps/{id}")
	private InitialEarningsPerSale show(@PathVariable int id) {
		return ieSvc.show(id);
	}
	
	
	

}
