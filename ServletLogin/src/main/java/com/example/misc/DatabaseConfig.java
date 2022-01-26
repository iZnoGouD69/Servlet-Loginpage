package com.example.misc;

public class DatabaseConfig {
	
	protected static String loginQuery = "select * from users where username=? and password=?";
	
	protected static String INSERT_TODOS_SQL ="INSERT INTO todos"
			+ "(title, username, description, target_date, is_done) values "
			+ "(?,?,?,?,?);";

	protected static String SELECT_ALL_TODOS = "select * from todos";

	protected static String SELECT_BY_USER = "select * from todos where username = ?";
	
	protected static String INSERT_USERS_SQL = "INSERT INTO users (firstname,username,password) VALUES " +
			" (?,?,?);";
	
	protected static String url = "jdbc:mysql://localhost:3306/";
	protected static String dbName = "notesusers";
	protected static String dbUsername = "root";
	protected static String dbPassword = "Z3r0_c00l!";
}
