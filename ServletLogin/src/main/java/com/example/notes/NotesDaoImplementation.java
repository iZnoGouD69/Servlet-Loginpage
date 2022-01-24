package com.example.notes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NotesDaoImplementation implements NotesDao {
	
	private static String INSERT_TODOS_SQL ="INSERT INTO todos"
					+ "(title, username, description, target_date, is_done) values "
					+ "(?,?,?,?,?);";
	
	private static String SELECT_ALL_TODOS = "select * from todos";
	
	private static String SELECT_BY_USER = "select * from todos where username = ?";

	@Override
	public void insertNote(NotesModel note) throws SQLException {
		// TODO Auto-generated method stub
		java.util.Date date =new java.util.Date();
		java.sql.Date sqlDate =new java.sql.Date(date.getTime());
		System.out.println(INSERT_TODOS_SQL);
		try(Connection connection = DriverManager
			.getConnection("jdbc:mysql://localhost:3306/notesusers?useSSL=false","root","Z3r0_c00l!");
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TODOS_SQL)) {
			preparedStatement.setString(1,note.getTitle());
			preparedStatement.setString(2, note.getUsername());
			preparedStatement.setString(3, note.getDescription());
			preparedStatement.setDate(4, sqlDate);
			preparedStatement.setBoolean(5, note.getStatus());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
	}

	@Override
	public NotesModel selectNote(String username1) {
		// TODO Auto-generated method stub
		
		NotesModel nm = null;
		
		try(Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/notesusers?useSSL=false","root","Z3r0_c00l!");
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_USER)) {
			preparedStatement.setString(1, username1);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				long id = rs.getLong("id");
				String title = rs.getString("title");
				String username = rs.getString("username");
				String description = rs.getString("description");
				LocalDate targetDate = rs.getDate("target_date").toLocalDate();
				boolean isDone = rs.getBoolean("is_done");
				
				nm = new NotesModel(id,title,username,description,targetDate,isDone);
			}
			
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return nm;
		
		
	}

	@Override
	public List<NotesModel> selectAllNotes(String username) {
		// TODO Auto-generated method stub
		List<NotesModel> notes = new ArrayList<>();
		
		try(Connection connection = DriverManager
			.getConnection("jdbc:mysql://localhost:3306/notesusers?useSSL=false","root","Z3r0_c00l!");
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_USER)){
            preparedStatement.setString(1, username);

			System.out.println(preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				long id = rs.getLong("id");
				String title = rs.getString("title");
				String username1 = rs.getString("username");
				String description = rs.getString("description");
				LocalDate targetDate = rs.getDate("target_date").toLocalDate();
				boolean isDone = rs.getBoolean("is_done");
				notes.add(new NotesModel(id, title, username1, description, targetDate, isDone));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return notes;
	}

	@Override
	public boolean deleteNote(int id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateNote(NotesModel note) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
