package com.revature.bank.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;

import com.revature.bank.launcher.BankAppLauncher;
import com.revature.bank.models.User;
import com.revature.bank.util.ConnectionFactory;
import com.revature.bank.exceptions.UserNotFoundException;

public class UserDaoImpl implements UserDao{
	private static UserDaoImpl instance;
	
	//public static BankAppLauncher.logger BankAppLauncher.logger = LogManager.getBankAppLauncher.logger("com.revature.bank");

	public UserDaoImpl() {
	}

	public static UserDaoImpl getInstance() {
		if (instance == null) {
			instance = new UserDaoImpl();
		}
		return instance;
	}
	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();

	public User getUser(String name) throws UserNotFoundException {
		Connection conn = cf.getConnection();
		try  {
			PreparedStatement ps = conn
					.prepareStatement("SELECT username, password, balance, is_employee, is_approved, account_id " + "FROM users WHERE username = ?");
			ps.setString(1, name);
			BankAppLauncher.logger.trace("getUser query executing...");
			ResultSet rs = ps.executeQuery();
			BankAppLauncher.logger.trace("query done.");
			if (rs.next()) {
				return new User(rs.getString("username"), rs.getString("password"), rs.getFloat("balance"), rs.getBoolean("is_employee"),
						rs.getBoolean("is_approved"), rs.getInt("account_id"));
			}
		} 
		catch (Exception e) {
			e.getMessage();
		}
		return null;

	}
	
	public String getRecUser(String name) throws UserNotFoundException{
		Connection conn = cf.getConnection();
		String recUser = null;
		try  {
			PreparedStatement ps = conn
					.prepareStatement("SELECT username, password, balance, is_employee, is_approved " + "FROM users WHERE username = ?");
			ps.setString(1, name);
			BankAppLauncher.logger.trace("getUser query executing...");
			ResultSet rs = ps.executeQuery();
			BankAppLauncher.logger.trace("query done.");
			if (rs.next()) {
				return recUser = rs.getString("username");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error code: " + e.getErrorCode());
		}

		return recUser;

	}

	public int getAccId(String name) {
		Connection conn = cf.getConnection();
	//	String recUser = null;
		int accId=0;
		try  {
			PreparedStatement ps = conn
					.prepareStatement("SELECT account_id " + "FROM users WHERE username = ?");
			ps.setString(1, name);
			BankAppLauncher.logger.trace("getUser query executing...");
			ResultSet rs = ps.executeQuery();
			BankAppLauncher.logger.trace("query done.");
			if (rs.next()) {
				return accId = rs.getInt("account_id");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error code: " + e.getErrorCode());
		}
		System.out.println("account id........"+accId);
		BankAppLauncher.logger.debug("No user found (Result set empty)");
		return accId;

	}
	
	public boolean insertUser(User u) {
		Connection conn = cf.getConnection();
		try  {
			// INSERT INTO user_account VALUES ('Ian', 123.45, 1, 1);
			int idx = 0;
			// CallableStatement stmt = conn.prepareCall("{CALL update_pokemon(?, ?, ?, ?,
			// ?)}");
			PreparedStatement ps = conn.prepareStatement("INSERT INTO users(username, password, balance, is_employee, is_approved)"
					+ "VALUES (?, ?, ?, ?, ?)");
			ps.setString(++idx, u.getName());
			ps.setString(++idx, u.getPassword());
			ps.setFloat(++idx, u.getBalance());
			ps.setBoolean(++idx, u.isAdmin());
			ps.setBoolean(++idx, u.isApproved());
			//ps.setInt(++idx, u.getAccountId());
			
			BankAppLauncher.logger.trace("executing INSERT...");
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.print(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error code: " + e.getErrorCode());
		}

		BankAppLauncher.logger.debug("INSERT user failed: " + u);
		return false;
	}

	public boolean deleteUser(User u) throws UserNotFoundException {
		// DELETE FROM user_account WHERE name = 'Ian B';
		Connection conn = cf.getConnection();
		try  {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM users WHERE username = ?");
			ps.setString(1, u.getName());

			BankAppLauncher.logger.trace("executing DELETE...");
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error code: " + e.getErrorCode());
		}

		BankAppLauncher.logger.debug("DELETE user failed: " + u);
		return false;
	}

	public boolean updateUser(User u) throws UserNotFoundException{
		// UPDATE user_account SET balance = 4.0, approved = 0 WHERE name = ?;
		Connection conn = cf.getConnection();
		try  {
			int idx = 0;
			PreparedStatement ps = conn.prepareStatement("UPDATE users SET "
					+ "balance = ?, is_approved = ?, is_employee = ? WHERE username = ?");
			ps.setFloat  (++idx, u.getBalance());
			ps.setBoolean(++idx, u.isApproved());
			ps.setBoolean(++idx, u.isAdmin());
			ps.setString (++idx, u.getName());

			BankAppLauncher.logger.trace("executing UPDATE to User..." + u);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error code: " + e.getErrorCode());
		}

		BankAppLauncher.logger.debug("UPDATE user modified 0 rows: " + u);
		return false;
	}
	
	public boolean updateDeposit(User u, float balance) throws UserNotFoundException {
		// UPDATE user_account SET balance = 4.0, approved = 0 WHERE name = ?;
		Connection conn = cf.getConnection();
		try  {
			int idx = 0;
			PreparedStatement ps = conn.prepareStatement("UPDATE users SET  "
					+ "balance = ?, is_approved = ?, is_employee = ? WHERE username = ?");
			ps.setFloat  (++idx, balance);
			ps.setBoolean(++idx, u.isApproved());
			ps.setBoolean(++idx, u.isAdmin());
			ps.setString (++idx, u.getName());

			BankAppLauncher.logger.trace("executing UPDATE to User..." + u);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error code: " + e.getErrorCode());
		}

		BankAppLauncher.logger.debug("UPDATE user modified 0 rows: " + u);
		return false;
	}

	@Override
	public Map<String, User> getAllUsers() throws UserNotFoundException{
		Map<String, User> um = new HashMap<>();
		Connection conn = cf.getConnection();
		try  {
			PreparedStatement ps = conn
					.prepareStatement("SELECT username, password, balance, is_employee, is_approved, account_id"
							+ " FROM USERS");
			BankAppLauncher.logger.trace("getAllUsers query executing...");
			ResultSet rs = ps.executeQuery();
			BankAppLauncher.logger.trace("query done.");
			while (rs.next()) {
				User u = new User(rs.getString("username"), 
							rs.getString("password"), 
							rs.getFloat("balance"),
							rs.getBoolean("is_employee"),
							rs.getBoolean("is_approved"),
							rs.getInt("account_id"));
				um.put(u.getName(), u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error code: " + e.getErrorCode());
		}

		BankAppLauncher.logger.debug("getAll elements in map: " + um.size());
		return um;
	}
	
	//@Override
	public Map<String, User> getUsersForApprove() throws UserNotFoundException{
		Map<String, User> um = new HashMap<>();
		Connection conn = cf.getConnection();
		try  {
			PreparedStatement ps = conn
					.prepareStatement("SELECT username, password, balance, is_employee, is_approved "
							+ "FROM users where is_approved='false'");
			BankAppLauncher.logger.trace("getAllUsers query executing...");
			ResultSet rs = ps.executeQuery();
			BankAppLauncher.logger.trace("query done.");
			while (rs.next()) {
				User u = new User(rs.getString("username"), 
							rs.getString("password"), 
							rs.getFloat("balance"),
							rs.getBoolean("is_employee"),
							rs.getBoolean("is_approved"));
				um.put(u.getName(), u);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error code: " + e.getErrorCode());
		}

		BankAppLauncher.logger.debug("getAll elements in map: " + um.size());
		return um;
	}
}