package dev.richardnewman.cbmetrics.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.richardnewman.cbmetrics.entities.Product;
import dev.richardnewman.cbmetrics.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository prodRepo;

	@Override
	public List<Product> index() {
		return prodRepo.findAll();
	}

	@Override
	public Product show(int id) {
		Product prod = null;
		Optional<Product> opt = prodRepo.findById(id);
		if (opt.isPresent()) {
			prod = opt.get();
			return prod;
		}
		return null;
	}

	@Override
	public Product create(Product product) {
		return prodRepo.saveAndFlush(product);
	}

	@Override
	public Product update(int id, Product product) {
		Product update = null;
		Optional<Product> opt = prodRepo.findById(id);
		if (opt.isPresent()) {
			update = opt.get();
		}
		update.setActiveDate(product.getActiveDate());
		update.setAvgEarningsPerSale(product.getAvgEarningsPerSale());
		update.setCategories(product.getCategories());
		update.setCbID(product.getCbID());
		update.setCommission(product.getCommission());
		update.setDescription(product.getDescription());
		update.setGravity(product.getGravity());
		update.setHasRecurringProducts(product.isHasRecurringProducts());
		update.setInitialEarningsPerSale(product.getInitialEarningsPerSale());
		update.setPercentPerRebill(product.getPercentPerRebill());
		update.setPercentPerSale(product.getPercentPerSale());
		update.setPopularityRank(product.getPopularityRank());
		update.setReferred(product.getReferred());
		update.setTitle(product.getTitle());
		update.setTotalRebillAmt(product.getTotalRebillAmt());
		prodRepo.saveAndFlush(update);
		return update;
	}

	@Override
	public boolean destroy(int id) {
		Product delete = prodRepo.findById(id).get();
		
		if(delete != null) {
			prodRepo.delete(delete);
			return true;
		} else {
			return false;
		}
		
	}
		

}
