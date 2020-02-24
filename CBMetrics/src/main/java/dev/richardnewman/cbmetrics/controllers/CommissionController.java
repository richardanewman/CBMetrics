package dev.richardnewman.cbmetrics.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.richardnewman.cbmetrics.entities.Commission;
import dev.richardnewman.cbmetrics.services.CommissionService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4288" })
public class CommissionController {
	
	@Autowired
	private CommissionService comSvc;
	
	@GetMapping("commission")
	private List<Commission> index(){
		return comSvc.index();
	}
	
	@GetMapping("commission/product/{pid}")
	private List<Commission> showAllByProductId(@PathVariable int pid) {
		return comSvc.showByProductID(pid);
	}
	
	@GetMapping("commission/{id}")
	private Commission show(@PathVariable int id) {
		return comSvc.show(id);
	}
	
	
	

}
