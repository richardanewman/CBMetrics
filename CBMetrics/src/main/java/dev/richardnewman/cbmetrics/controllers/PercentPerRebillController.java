package dev.richardnewman.cbmetrics.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.richardnewman.cbmetrics.entities.PercentPerRebill;
import dev.richardnewman.cbmetrics.services.PercentPerRebillService;

@RestController
@RequestMapping("api")
public class PercentPerRebillController {
	
	@Autowired
	private PercentPerRebillService prSvc;
	
	@GetMapping("rebill")
	private List<PercentPerRebill> index(){
		return prSvc.index();
	}
	
	@GetMapping("rebill/product/{pid}")
	private List<PercentPerRebill> showAllByProductId(@PathVariable int pid) {
		return prSvc.showByProductID(pid);
	}
	
	@GetMapping("rebill/{id}")
	private PercentPerRebill show(@PathVariable int id) {
		return prSvc.show(id);
	}
	
	
	

}
