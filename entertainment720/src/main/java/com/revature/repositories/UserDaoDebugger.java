package com.revature.repositories;

import com.revature.exception.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;

public class UserDaoDebugger {

	public static void main(String[] args) throws UserNotFoundException, InternalErrorException {
		// TODO Auto-generated method stub
		UserDao ud = new UserPostgresDao();
		
		System.out.println(ud.findUserByUsernameAndPassword("AB", "password"));
	}

}
