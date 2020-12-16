package com.revature.bank.repositories;

import java.sql.SQLException;
import java.util.Map;

import com.revature.bank.exceptions.UserNotFoundException;
import com.revature.bank.models.User;

public interface UserDao {
	public boolean insertUser(User user);

	public User getUser(String name) throws UserNotFoundException;

	public boolean updateUser(User user) throws UserNotFoundException;

	public boolean deleteUser(User user) throws UserNotFoundException;

	 public abstract Map<String, User> getAllUsers() throws UserNotFoundException;
}
