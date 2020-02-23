package dev.richardnewman.cbmetrics.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.richardnewman.cbmetrics.entities.UserAccount;
import dev.richardnewman.cbmetrics.repositories.UserAccountRepository;

@Service
public class UserAccountServiceImpl implements UserAccountService {
	
	@Autowired
	private UserAccountRepository uaRepo;
	
	@Autowired
	private AuthService authSvc;

	@Override
	public List<UserAccount> index() {
		return uaRepo.findAll();
	}

	@Override
	public UserAccount show(String username, int id) {
		UserAccount userAccount = uaRepo.findByUsernameAndId(username, id);
		return userAccount;
	}

	@Override
	public UserAccount show(String username) {
		UserAccount userAccount = uaRepo.findByUsername(username);
		return userAccount;
	}

	@Override
	public UserAccount create(UserAccount user) {
		if (user != null) {
			return authSvc.register(user);
		}
		return null;
	}

	@Override
	public UserAccount update(int id, UserAccount user) {
		UserAccount updateUser = uaRepo.findById(id).get();
		
		if (updateUser != null) {
			updateUser.setEmail(user.getEmail());
			updateUser.setUsername(user.getUsername());
			
			return uaRepo.saveAndFlush(updateUser);
			
		} else {
			
			return null;
		}
		
	} 

	@Override
	public boolean destroy(int id) {
		UserAccount deleteUser = uaRepo.findById(id).get();
		
		if (deleteUser != null) {
			uaRepo.delete(deleteUser);
			return true;
		}
		return false;
	}

	
	
	
	
	

}
