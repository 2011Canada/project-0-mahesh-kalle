package com.revature.repositories;

import java.util.List;

import com.revature.exception.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public interface UserDao {

	public User findUserByUsernameAndPassword(String username, String password) throws UserNotFoundException, InternalErrorException;
	
	
	public List<User> findAll();
}
