package dev.richardnewman.cbmetrics.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.richardnewman.cbmetrics.entities.UserAccount;
import dev.richardnewman.cbmetrics.services.AuthService;

@RestController
@CrossOrigin({ "*", "http://localhost:4288" })
public class AuthController {
	
	@Autowired
	private AuthService svc;
	
	@PostMapping("/register")
	public UserAccount register(@RequestBody UserAccount user, HttpServletResponse res) {
		
		if(user == null) {
			res.setStatus(400);
			return null;
		} else {
			res.setStatus(200);
			return svc.register(user);
		}
	}
	
	@GetMapping("/authenticate")
	public Principal authenticate(Principal principal) {
		return principal;
	}

}
