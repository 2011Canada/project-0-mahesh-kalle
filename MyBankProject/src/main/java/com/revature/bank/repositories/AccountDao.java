package com.revature.bank.repositories;

import java.util.Map;

import com.revature.bank.exceptions.AccountNotFoundException;
import com.revature.bank.models.Account;

public interface AccountDao {

	public boolean transaction(int accountId, String username, String transactionType, float amount) throws AccountNotFoundException;
	
	public Map<String, Account> getAllLogs() throws AccountNotFoundException;
	
	public Account getCustAcc(String name) throws AccountNotFoundException;
}
