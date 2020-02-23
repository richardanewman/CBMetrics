package dev.richardnewman.cbmetrics.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.richardnewman.cbmetrics.entities.UserAccount;
import dev.richardnewman.cbmetrics.services.UserAccountService;

@RestController
@RequestMapping("api")
public class UserAccountController {
	
	@Autowired
	private UserAccountService svc;
	
	@GetMapping("users")
	public List<UserAccount> index(){
		return svc.index();
	}
	
	@GetMapping("users/{id}")
	private UserAccount getById(@PathVariable int id, 
			HttpServletRequest req,
			HttpServletResponse res,
			Principal principal) {
		try {
		StringBuffer url = req.getRequestURL();
		System.out.println(url.toString());
		res.addHeader("Location", url.toString());
		res.setStatus(200);
		return svc.show(principal.getName(), id);
		
		} catch (Exception e) {
			res.setStatus(404);
			return null;
			
		}
		
	}
	
	@GetMapping("user")
	private UserAccount getUserInSession(
			HttpServletRequest req,
			HttpServletResponse res,
			Principal principal) {
		try {
			StringBuffer url = req.getRequestURL();
			res.addHeader("Location", url.toString());
			res.setStatus(200);
			return svc.show(principal.getName());
			
		} catch (Exception e) {
			res.setStatus(400);
			return null;
			
		}
		
	}
	
	//AuthController and AuthServiceImpl contains Create/Register New User Account
	
	@PutMapping("users/{id}")
	private UserAccount updateAccount(
			@PathVariable int id,
			@RequestBody UserAccount user,
			HttpServletRequest req,
			HttpServletResponse res) {
		
		try {
			user = svc.update(id, user);
			res.setStatus(200);
			return user;
			
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(204);
			return null;
		}
	}
	
	@DeleteMapping("users/{id}")
	private boolean deleteAccount(
			@PathVariable int id,
			HttpServletResponse res) {
		try {
			svc.destroy(id);
			res.setStatus(200);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			return false;
		}
	}
	
	

}
