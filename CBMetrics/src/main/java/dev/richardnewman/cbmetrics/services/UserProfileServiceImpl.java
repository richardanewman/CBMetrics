package dev.richardnewman.cbmetrics.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.richardnewman.cbmetrics.entities.UserProfile;
import dev.richardnewman.cbmetrics.repositories.UserProfileRepository;

@Service
public class UserProfileServiceImpl implements UserProfileService {
	
	@Autowired
	private UserProfileRepository upRepo;

	@Override
	public List<UserProfile> index() {
		return upRepo.findAll();
	}

	@Override
	public UserProfile show(int id) {
		return upRepo.findById(id).get();
		
	}

	@Override
	public UserProfile update(int id, UserProfile user) {
		UserProfile update = null;
		Optional<UserProfile> opt = upRepo.findById(id);
		if (opt.isPresent()) {
			update = opt.get();
		}
		update.setBio(user.getBio());
		update.setBusiness(user.getBusiness());
		update.setCity(user.getCity());
		update.setFirstName(user.getFirstName());
		update.setLastName(user.getLastName());
		update.setProfilePic(user.getProfilePic());
		update.setState(user.getState());
		update.setWebsite(user.getWebsite());
		upRepo.saveAndFlush(update);
		return update;
	}
	
	

}
