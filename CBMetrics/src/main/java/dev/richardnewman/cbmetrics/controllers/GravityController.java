package dev.richardnewman.cbmetrics.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.richardnewman.cbmetrics.entities.Gravity;
import dev.richardnewman.cbmetrics.services.GravityService;

@RestController
@RequestMapping("api")
public class GravityController {
	
	@Autowired
	private GravityService gSvc;
	
	@GetMapping("gravity")
	private List<Gravity> index(){
		return gSvc.index();
	}
	
	@GetMapping("gravity/product/{pid}")
	private List<Gravity> showAllByProductId(@PathVariable int pid) {
		return gSvc.showByProductID(pid);
	}
	
	@GetMapping("gravity/{id}")
	private Gravity show(@PathVariable int id) {
		return gSvc.show(id);
	}
	
	
	

}
