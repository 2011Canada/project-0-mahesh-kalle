package com.revature.bank.repositories;

import java.util.Map;

import com.revature.bank.models.User;

public interface UserDao {
	public boolean insertUser(User user);

	public User getUser(String name);

	public boolean updateUser(User user);

	public boolean deleteUser(User user);

	 public abstract Map<String, User> getAllUsers();
}
