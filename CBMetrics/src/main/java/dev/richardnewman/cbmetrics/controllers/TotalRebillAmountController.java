package dev.richardnewman.cbmetrics.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.richardnewman.cbmetrics.entities.TotalRebillAmount;
import dev.richardnewman.cbmetrics.services.TotalRebillAmountService;

@RestController
@RequestMapping("api")
public class TotalRebillAmountController {
	
	@Autowired
	private TotalRebillAmountService traSvc;
	
	@GetMapping("total-rebill")
	private List<TotalRebillAmount> index(){
		return traSvc.index();
	}
	
	@GetMapping("total-rebill/product/{pid}")
	private List<TotalRebillAmount> showAllByProductId(@PathVariable int pid) {
		return traSvc.showByProductID(pid);
	}
	
	@GetMapping("total-rebill/{id}")
	private TotalRebillAmount show(@PathVariable int id) {
		return traSvc.show(id);
	}
	
	
	

}
