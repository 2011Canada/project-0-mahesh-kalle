package com.revature.bank.menus;

import java.util.Map;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.bank.models.User;
import com.revature.bank.repositories.AccountDaoImpl;
import com.revature.bank.repositories.UserDaoImpl;

public class AccountMenu {
	
	public static Logger logger = LogManager.getLogger("com.revature.bank");
	//private static User user = null;
	User user = new User();
	final static UserDaoImpl dao = UserDaoImpl.getInstance();
	private static Scanner sc = new Scanner(System.in);
	AccountDaoImpl accDao = new AccountDaoImpl();
	
	public void deposit(User user) {
		System.out.println(user.getName() + " your current balance is : $" + user.getBalance());
		System.out.println("Enter the amount to deposit: ");
		System.out.print("$");
		float deposit = sc.nextFloat();
		Map<String, User> m = dao.getAllUsers();
		User enteredUser = m.get(user.getName()); 
		if(deposit > 0) {
			logger.info("amount entered: " + deposit);
			float balance = user.deposit(deposit);
			dao.updateDeposit(enteredUser, balance);
			accDao.transaction(enteredUser,"deposit",deposit);
		}
		else
			System.out.println("Please enter valid amount.");

		System.out.println(user.getName() + " your new balance is : $" + user.getBalance());
	}

	public void withdraw(User user) {
		System.out.println(user.getName() + " your current balance is : $" + user.getBalance());
		System.out.println("Enter the amount to withdraw: ");
		System.out.print("$");
		float withdrawal = sc.nextFloat();
		if(withdrawal > 0) {
			logger.info("amount entered: " + withdrawal);
			user.withdraw(withdrawal);
		}
		else
			System.out.println("Please enter valid amount.");

		System.out.println(user.getName() + " your new balance is : $" + user.getBalance());
	}


}
