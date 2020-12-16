package com.revature.bank.exceptions;

public class AccountNotFoundException extends Exception {


	private static int numberOfOccurances =0;
	
	
	public AccountNotFoundException() {
		super("Account Not Found, Please Try Again");
		numberOfOccurances++;
	}
}
