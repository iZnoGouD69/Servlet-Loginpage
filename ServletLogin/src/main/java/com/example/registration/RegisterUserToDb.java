package com.example.registration;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.example.db.ConnectDatabase;

public class RegisterUserToDb {
	
	public int registerUser(RegisterUser user) throws ClassNotFoundException, SQLException{

		int result = 0;
		Class.forName("com.mysql.jdbc.Driver");	
		PreparedStatement preparedStatement = ConnectDatabase.getConnection()
				  							.prepareStatement(ConnectDatabase.INSERT_USERS_SQL);
		
		preparedStatement.setString(1, user.getFirstname());
		preparedStatement.setString(2,user.getUsername());
		preparedStatement.setString(3,user.getPassword());
		
		System.out.println(preparedStatement);
		result = preparedStatement.executeUpdate();
		
		return result;
	}    
}
