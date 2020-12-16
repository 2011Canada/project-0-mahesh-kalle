package com.revature.bank.service;

import com.revature.bank.models.User;

public interface AccountService {
	
	public void logTransactions();
	
	public void deposit(User user);
	
	public void withdraw(User user);
	
	public void transfer(User user);
	
}
