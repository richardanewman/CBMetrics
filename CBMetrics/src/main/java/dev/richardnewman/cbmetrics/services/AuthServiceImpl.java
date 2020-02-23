package dev.richardnewman.cbmetrics.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.richardnewman.cbmetrics.entities.UserAccount;
import dev.richardnewman.cbmetrics.repositories.UserAccountRepository;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private UserAccountRepository uaRepo;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public UserAccount register(UserAccount user) {
		String encrypted = encoder.encode(user.getPassword());
		user.setPassword(encrypted);
		user.setEnabled(true);
		user.setRole("STANDARD");
		uaRepo.saveAndFlush(user);
		return user;
	}
}
