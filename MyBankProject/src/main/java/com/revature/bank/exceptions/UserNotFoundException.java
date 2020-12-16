package com.revature.bank.exceptions;

public class UserNotFoundException extends Exception {
	public UserNotFoundException() {
		super("User Not Found");
	}
}
