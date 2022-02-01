package com.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
	
	public static final String url = "jdbc:mysql://localhost:3306/";
	public static final String extra = "?useSSL=false";
	public static final String dbName = "notesusers";
	public static final String dbUsername = "root";
	public static final String dbPassword = "Z3r0_c00l!";
	
    public static final String DELETE_NOTE_BY_ID = "delete from notes where id = ?;";

	public static final String loginQuery = "select * from users where username=? and password=?";
	
	public static final String INSERT_NOTE_SQL ="INSERT INTO notes"
			+ "(title, username, description, target_date, is_done) values "
			+ "(?,?,?,?,?);";

	//public static final String SELECT_ALL_TODOS = "select * from todos";

	public static final String SELECT_BY_USER = "select * from notes where username = ?";
	
	public static final String INSERT_USERS_SQL = "INSERT INTO users (firstname,username,password) VALUES " +
			" (?,?,?);";
	
	public static final String UPDATE_NOTE_SQL = "UPDATE notes set title = ?, username = ?, description = ?, "
			+ "target_date = ?, is_done = ? where id =  ?";

	
	static Connection connection = null;
	
	public static Connection getConnection() {
		if(connection != null) {
			return connection;
		}
		return getConnection(dbName,dbUsername,dbPassword);
	}
	
	private static Connection getConnection(String dbName, String dbUsername, String dbPassword) {
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url + dbName + extra,dbUsername,dbPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
