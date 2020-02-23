package dev.richardnewman.cbmetrics.services;

import java.util.List;

import dev.richardnewman.cbmetrics.entities.UserProfile;

public interface UserProfileService {
	
	public List<UserProfile> index();
	
	public UserProfile show(int id);
	
	public UserProfile update(int id, UserProfile user);
	
	

}
