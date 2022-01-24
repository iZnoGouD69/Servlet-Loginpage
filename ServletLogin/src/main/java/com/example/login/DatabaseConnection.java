package com.example.login;

public class DatabaseConnection {
	
	static String url = "jdbc:mysql://localhost:3306/";
	static String dbName = "notesusers";
	static String dbUsername = "root";
	static String dbPassword = "Z3r0_c00l!";
	static String loginQuery = "select * from users where username=? and password=?";
}
