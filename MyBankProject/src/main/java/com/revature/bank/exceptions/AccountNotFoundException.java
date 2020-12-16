package com.revature.bank.exceptions;

public class AccountNotFoundException extends Exception {


	public AccountNotFoundException() {
		super("Account Not Found, Please Try Again");
	}
}
