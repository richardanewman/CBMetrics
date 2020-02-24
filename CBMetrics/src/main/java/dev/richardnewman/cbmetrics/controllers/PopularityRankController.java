package dev.richardnewman.cbmetrics.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.richardnewman.cbmetrics.entities.PopularityRank;
import dev.richardnewman.cbmetrics.services.PopularityRankService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4288" })
public class PopularityRankController {
	
	
	@Autowired
	private PopularityRankService popSvc;
	
	@GetMapping("rank")
	private List<PopularityRank> index(){
		return popSvc.index();
	}
	
	@GetMapping("rank/product/{pid}")
	private List<PopularityRank> showAllByProductId(@PathVariable int pid) {
		return popSvc.showByProductID(pid);
	}
	
	@GetMapping("rank/{id}")
	private PopularityRank show(@PathVariable int id) {
		return popSvc.show(id);
	}
	
	
	

}
