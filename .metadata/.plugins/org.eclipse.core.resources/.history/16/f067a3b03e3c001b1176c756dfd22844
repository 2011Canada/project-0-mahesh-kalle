package com.revature.services;

import com.revature.exception.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.launcher.Entertainment720Launcher;
import com.revature.models.Displayable;
import com.revature.models.User;
import com.revature.repositories.UserDao;

public class UserServiceImplementation implements UserService {
	
	private UserDao ud;
	
	public UserServiceImplementation(UserDao ud) {
		this.ud = ud;
	}
	
	
	
	@Override
	public Displayable login(String username, String password) {
		try {
			User u = ud.findUserByUsernameAndPassword(username, password);
			Entertainment720Launcher.setCurrentUser(u);
			return u;
		} catch (UserNotFoundException | InternalErrorException e) {
			// TODO Auto-generated catch block
			return ()->e.getMessage();
		}
	}

}
