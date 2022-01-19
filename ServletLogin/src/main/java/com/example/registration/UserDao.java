package com.example.registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UserDao {
	
	public int registerUser(UserRegistration user) throws ClassNotFoundException{
		
		String INSERT_USERS_SQL = "INSERT INTO users" +
				" (firstname,username,password) VALUES " +
				" (?,?,?);";
		
		int result = 0;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection = DriverManager
			.getConnection("jdbc:mysql://localhost:3306/notesusers?useSSL=false","root","Z3r0_c00l!");
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
			preparedStatement.setString(1, user.getFirstname());
			preparedStatement.setString(2,user.getUsername());
			preparedStatement.setString(3,user.getPassword());
			System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
