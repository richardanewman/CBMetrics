package dev.richardnewman.cbmetrics.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.richardnewman.cbmetrics.entities.UserProfile;
import dev.richardnewman.cbmetrics.services.UserProfileService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4288" })
public class UserProfileController {
	
	@Autowired
	private UserProfileService profileSvc;
	
	@GetMapping("profiles")
	public List<UserProfile> index() {
		return profileSvc.index();
	}
	
	@GetMapping("profile/{id}")
	private UserProfile getProfileById(@PathVariable int id) {
		return profileSvc.show(id);
	}
	
	@PutMapping("profile/{id}")
	private UserProfile updateProfile(@PathVariable int id,
			@RequestBody UserProfile profile,
			HttpServletResponse res) {
		
		try {
			profile = profileSvc.update(id, profile);
			res.setStatus(200);
			return profile;
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			return null;
		}
	
	}
	

}
