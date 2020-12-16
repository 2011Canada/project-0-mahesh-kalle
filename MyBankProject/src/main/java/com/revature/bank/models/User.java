package com.revature.bank.models;

import java.util.HashMap;
import java.util.Map;


public class User{
	/**
	 * 
	 */
	private String name;
	private String password = "ttt";
	private float balance = 0;
	private boolean admin = false;
	private boolean approved = false;
	private String recipientUser;
	private int accountId;
	
	private static Map<String, User> users = new HashMap<>(2);		// persistent storage :P
	
	public User(String name) {
		this.name = name;
		users.put(name, this);
	}
	
	public User(String name, String password,float balance, boolean admin, boolean approved) {
		this.name = name;
		this.password = password;
		this.balance = balance;
		this.admin = admin;
		this.approved = approved;
		users.put(name, this);
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public float deposit(float deposit) {
		balance += deposit;
		return balance;
	}
	
	public float withdraw(float withdrawal) {
		return balance -= withdrawal;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", balance=" + balance + ", admin=" + admin
				+ ", approved=" + approved + ", recipientUser=" + recipientUser + ", accountId=" + accountId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(accountId);
		result = prime * result + (admin ? 1231 : 1237);
		result = prime * result + (approved ? 1231 : 1237);
		result = prime * result + Float.floatToIntBits(balance);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((recipientUser == null) ? 0 : recipientUser.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (Float.floatToIntBits(accountId) != Float.floatToIntBits(other.accountId)) 
				return false;
		if (admin != other.admin)
			return false;
		if (approved != other.approved)
			return false;
		if (Float.floatToIntBits(balance) != Float.floatToIntBits(other.balance))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (recipientUser == null) {
			if (other.recipientUser != null)
				return false;
		} else if (!recipientUser.equals(other.recipientUser))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public static Map<String, User> getUsers() {
		return users;
	}

	public static void setUsers(Map<String, User> users) {
		User.users = users;
	}
	public String getRecipientUser() {
		return recipientUser;
	}

	public void setRecipientUser(String recipientUser) {
		this.recipientUser = recipientUser;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public User(String name, String password, float balance, boolean admin, boolean approved, int accountId) {
		super();
		this.name = name;
		this.password = password;
		this.balance = balance;
		this.admin = admin;
		this.approved = approved;
		this.recipientUser = recipientUser;
		this.accountId = accountId;
	}
	
	
}
