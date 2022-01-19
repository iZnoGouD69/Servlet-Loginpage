package com.example.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	
	public static boolean validate(String username, String password) throws ClassNotFoundException {
		boolean status = false;
		
		Class.forName("com.mysql.jdbc.Driver");
		try {
			Connection connection = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/notesusers?useSSL=false","root","Z3r0_c00l!");
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from "
					+ "users where username=? and password=?");
			preparedStatement.setString(1,username);
			preparedStatement.setString(2,password);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			status = resultSet.next();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

}
