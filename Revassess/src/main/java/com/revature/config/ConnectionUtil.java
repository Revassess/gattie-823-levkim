package com.revature.config;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.dialect.PostgreSQLDialect;
import org.postgresql.Driver;

/**
 * 
 * @author Revature
 *
 *         This is a paceholder class to hold the configurations of your db
 *         connection. You should change the url, username, and password. DO NOT
 *         CHANGE THE MODIFIERS OR THE NAMES OF THE VARIABLES. These are used to
 *         test your db schema.
 */
public class ConnectionUtil {
	//for singleton instance
	private static ConnectionUtil cu;
	
	// add your jdbc url
	public static final String URL = "jdbc:postgresql://demosdb.cnhivgivm0u1.us-east-1.rds.amazonaws.com/postgres";
	// add your jdbc username
	public static final String USERNAME = "postgres";
	// add your jdbc password
	public static final String PASSWORD = "password";
	// name of the created stored procedure in tier 3
	public static final String TIER_3_PROCEDURE_NAME = "";
	// name of the created sequence in tier 3
	public static final String TIER_3_SEQUENCE_NAME = "tier2test2";

	// implement this method to connect to the db and return the connection object
	public Connection connect(){
		try {
			DriverManager.registerDriver(new org.postgresql.Driver());
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


	//implement this method with a callable statement that calls the absolute value sql function
	public long callAbsoluteValueFunction(long value){
		try {
			long result = 0;
			CallableStatement stmt = connect().prepareCall("{? = call ABS(?)}");
			
			stmt.registerOutParameter(1, Types.BIGINT);
			stmt.setLong(2, value);
			stmt.execute();
			result = stmt.getLong(1);
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	

	//make the class into a singleton
	private ConnectionUtil(){
		super();
	}

	public static ConnectionUtil getInstance(){
		if(cu == null){
			cu = new ConnectionUtil();
		}
		return cu;
	}
}
