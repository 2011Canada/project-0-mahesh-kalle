package com.revature.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.revature.bank.repositories.UserDaoImpl;

public class AccountTest {
	
	UserDaoImpl accDao = new UserDaoImpl();

	@Test
	public void Test() {
		
		int account_num = 406215;
		
		String cust_name = "user1";
		
		assertEquals(account_num, accDao.getAccId(cust_name));
		
	}
}
