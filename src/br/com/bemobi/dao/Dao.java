package br.com.bemobi.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao {
	private static final String URL  ="jdbc:mysql://localhost/bemobi";
	private static final String USER ="root";
	private static final String PASS ="root";
	
	
	public static Connection getConnection() throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(URL, USER, PASS);
		
	}
	
}
