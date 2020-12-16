package com.revature.bank.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.bank.exceptions.AccountNotFoundException;
import com.revature.bank.launcher.BankAppLauncher;
import com.revature.bank.models.Account;
import com.revature.bank.models.User;
import com.revature.bank.util.ConnectionFactory;

public class AccountDaoImpl implements AccountDao {
	
	//public static Logger logger = LogManager.getLogger("com.revature.bank");

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	
	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	
	public boolean transaction(int accountId, String username, String transactionType, float amount) throws AccountNotFoundException {
		
		Connection conn = cf.getConnection();
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Date date = new Date();
		
		try  {
			// INSERT INTO user_account VALUES ('Ian', 123.45, 1, 1);
			int idx = 0;
			// CallableStatement stmt = conn.prepareCall("{CALL update_pokemon(?, ?, ?, ?,
			// ?)}");
			PreparedStatement ps = conn.prepareStatement("INSERT INTO accounts (account_id, transaction_type, amount, username, transaction_date) "
					+ "VALUES (?, ?, ?, ?, ?)");
			ps.setInt(++idx, accountId);
			ps.setString(++idx, transactionType);
			ps.setFloat(++idx, amount);
			ps.setString(++idx, username);
			ps.setTimestamp(++idx, timestamp);

			BankAppLauncher.logger.trace("executing INSERT account statement...");
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println(e);
			System.err.print(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error code: " + e.getErrorCode());
		}

		BankAppLauncher.logger.debug("INSERT account failed: " + username);
		return false;
	}

	public Map<String, Account> getAllLogs() throws AccountNotFoundException {
		Map<String, Account> am = new HashMap<>();
		Connection conn = cf.getConnection();
		try  {
			PreparedStatement ps = conn
					.prepareStatement("SELECT account_id, transaction_type, amount, username, transaction_date "
							+ "FROM accounts");
			BankAppLauncher.logger.trace("getAllLogs query executing...");
			ResultSet rs = ps.executeQuery();
			BankAppLauncher.logger.trace("query done.");
			while (rs.next()) {
				
				Account acc = new Account(rs.getInt("account_id"),
										rs.getString("transaction_type"), 
										rs.getFloat("amount"),
										rs.getString("username"),
										rs.getTimestamp("transaction_date"));
				
				am.put(acc.getUsername(), acc);
 				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error code: " + e.getErrorCode());
		}

		BankAppLauncher.logger.debug("getAll elements in map: " + am.size());
		return am;
	}
	
	public Account getCustAcc(String name) throws AccountNotFoundException {
		Connection conn = cf.getConnection();
		Account acc = null;
		//Account acc = new Account();
		
		try  {
			PreparedStatement ps = conn
					.prepareStatement("SELECT account_id, transaction_type, amount, username, transaction_date " + "FROM accounts WHERE username = ?");
			ps.setString(1, name);
			BankAppLauncher.logger.trace("getUser query executing...");
			ResultSet rs = ps.executeQuery();
			BankAppLauncher.logger.trace("query done.");
			
			while (rs.next()) {
				
				 acc = new Account(rs.getInt("account_id"),
										rs.getString("transaction_type"), 
										rs.getFloat("amount"),
										rs.getString("username"),
										rs.getTimestamp("transaction_date"));
				
				//am.put(acc.getUsername(), acc);
 				
			}
		/*	if (rs.next()) {
				acc.
				return recUser = rs.getString("username");
			}
			else
				return recUser = "no_user";*/
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error code: " + e.getErrorCode());
		}

		return acc;

	}

}
