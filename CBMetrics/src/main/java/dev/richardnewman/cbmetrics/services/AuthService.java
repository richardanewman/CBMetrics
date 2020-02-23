package dev.richardnewman.cbmetrics.services;

import dev.richardnewman.cbmetrics.entities.UserAccount;

public interface AuthService {
	
	UserAccount register(UserAccount user);

}
