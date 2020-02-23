package dev.richardnewman.cbmetrics.services;

import java.util.List;

import dev.richardnewman.cbmetrics.entities.UserAccount;

public interface UserAccountService {
	
	public List<UserAccount> index();
	
	public UserAccount show(String username, int id);
	
	public UserAccount show(String username);
	
	public UserAccount create(UserAccount user);
	
	public UserAccount update(int id, UserAccount user);
	
	public boolean destroy(int id);
	

}
