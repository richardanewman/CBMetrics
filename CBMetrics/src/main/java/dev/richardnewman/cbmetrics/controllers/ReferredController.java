package dev.richardnewman.cbmetrics.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.richardnewman.cbmetrics.entities.Referred;
import dev.richardnewman.cbmetrics.services.ReferredService;

@RestController
@RequestMapping("api")
public class ReferredController {
	
	@Autowired
	private ReferredService refSvc;
	
	@GetMapping("referred")
	private List<Referred> index(){
		return refSvc.index();
	}
	
	@GetMapping("referred/product/{pid}")
	private List<Referred> showAllByProductId(@PathVariable int pid) {
		return refSvc.showByProductID(pid);
	}
	
	@GetMapping("referred/{id}")
	private Referred show(@PathVariable int id) {
		return refSvc.show(id);
	}
	
	
	

}
