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

import com.revature.bank.models.User;
import com.revature.bank.util.ConnectionFactory;

public class AccountDaoImpl {
	
	public static Logger logger = LogManager.getLogger("com.revature.bank");

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	
	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	
	public boolean transaction(User u, String transactionType, float amount) {
		
		Connection conn = cf.getConnection();
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Date date = new Date();
		
		try  {
			// INSERT INTO user_account VALUES ('Ian', 123.45, 1, 1);
			int idx = 0;
			// CallableStatement stmt = conn.prepareCall("{CALL update_pokemon(?, ?, ?, ?,
			// ?)}");
			PreparedStatement ps = conn.prepareStatement("INSERT INTO account (transaction_type, amount, username, transaction_date) "
					+ "VALUES (?, ?, ?, ?)");
			ps.setString(++idx, transactionType);
			ps.setFloat(++idx, amount);
			ps.setString(++idx, u.getName());
			ps.setTimestamp(++idx, timestamp);

			logger.trace("executing INSERT account statement...");
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error code: " + e.getErrorCode());
		}

		logger.debug("INSERT account failed: " + u);
		return false;
	}


}
