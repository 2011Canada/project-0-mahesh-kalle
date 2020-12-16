package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	private static Connection connection;	
	
	public static Connection getConnection() throws IOException, SQLException {
		Properties prop = new Properties();
		InputStream in = new FileInputStream("connection.properties");
		prop.load(in);
		
		//DB_PASSWORD=Shreyas123
		//DB_URL=jdbc:postgresql://database-1.cxt10ggq9zoa.us-east-1.rds.amazonaws.com:5432/postgres?currentSchema=entertainment720
		//DB_USER=postgres
				
		//String url = prop.getProperty("url");
		//String username = prop.getProperty("username");
		//String password = prop.getProperty("password");
		
		String url = "jdbc:postgresql://database-1.cxt10ggq9zoa.us-east-1.rds.amazonaws.com:5432/postgres?currentSchema=bankdemo";
		String username = "postgres";
		String password = "Shreyas123";
		
		if(connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, username, password);
		}
		System.out.println(connection + "Success!");
		return connection;
	}
}
