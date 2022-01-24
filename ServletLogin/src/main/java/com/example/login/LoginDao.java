package com.example.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public class LoginDao extends DatabaseConnection {
	
	public static boolean validate(String username, String password, HttpServletRequest request) throws ClassNotFoundException {
		boolean status = false;
		
		Class.forName("com.mysql.jdbc.Driver");
		try {
			Connection connection = DriverManager.getConnection(url + dbName,dbUsername,dbPassword);
			
			PreparedStatement preparedStatement = connection.prepareStatement(loginQuery);
			preparedStatement.setString(1,username);
			preparedStatement.setString(2,password);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			status = resultSet.next();
			
			String firstname = resultSet.getString("firstname");
			request.getSession().setAttribute("user", firstname);
			System.out.println(firstname);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

}
