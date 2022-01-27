package com.example.login;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.example.db.ConnectDatabase;

public abstract class LoginValidator  {
	
	public static boolean validate(String username, String password, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		boolean status = false; 
		
		Class.forName("com.mysql.jdbc.Driver");
		PreparedStatement preparedStatement = ConnectDatabase.getConnection()
											  .prepareStatement(ConnectDatabase.loginQuery);
			
		preparedStatement.setString(1,username);
		preparedStatement.setString(2,password);
			
		ResultSet resultSet = preparedStatement.executeQuery();
		status = resultSet.next();
		
		
		String firstname = resultSet.getString("firstname");
		
		request.getSession().setAttribute("name", firstname);
		request.getSession().setAttribute("user", username);
		System.out.println(username);		
		
		return status;
	}

}
