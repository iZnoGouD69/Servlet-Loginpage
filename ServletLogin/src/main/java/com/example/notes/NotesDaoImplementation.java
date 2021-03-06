package com.example.notes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.db.ConnectDatabase;
 
public class NotesDaoImplementation implements Notes  {
	
	
	@Override 
	public void insertNote(NotesModel note) throws SQLException {
		// TODO Auto-generated method stub
		java.util.Date date =new java.util.Date();
		java.sql.Date sqlDate =new java.sql.Date(date.getTime());
		System.out.println(ConnectDatabase.INSERT_NOTE_SQL);
		
		PreparedStatement preparedStatement = ConnectDatabase.getConnection()
				  .prepareStatement(ConnectDatabase.INSERT_NOTE_SQL);	
		
		preparedStatement.setString(1,note.getTitle());
		preparedStatement.setString(2, note.getUsername());
		preparedStatement.setString(3, note.getDescription());
		preparedStatement.setDate(4, sqlDate);
		preparedStatement.setString(5, note.getStatus());
		preparedStatement.executeUpdate();

		//preparedStatement.setBoolean(5, note.getStatus());
	}

	@Override
	public List<NotesModel> selectAllNotes(String username) throws SQLException {
		// TODO Auto-generated method stub
		List<NotesModel> listNotes = new ArrayList<>();

		PreparedStatement preparedStatement = ConnectDatabase.getConnection()
												 .prepareStatement(ConnectDatabase.SELECT_BY_USER);
        preparedStatement.setString(1, username);

		System.out.println(preparedStatement);
			
		ResultSet rs = preparedStatement.executeQuery();
			
		while(rs.next()) {
			long id = rs.getLong("id");
			String title = rs.getString("title");
			String username1 = rs.getString("username");
			String description = rs.getString("description");
			LocalDate targetDate = rs.getDate("target_date").toLocalDate();
			String isDone = rs.getString("is_done");
			listNotes.add(new NotesModel(id, title, username1, description, targetDate, isDone));
		}
		return listNotes;
	}
	
	@Override
	public boolean deleteNote(int id) throws SQLException {
		// TODO Auto-generated method stub
		boolean rowDeleted;
		PreparedStatement preparedStatement = ConnectDatabase.getConnection()
				 							.prepareStatement(ConnectDatabase.DELETE_NOTE_BY_ID);
		preparedStatement.setInt(1, id);
		rowDeleted = preparedStatement.executeUpdate() > 0;
		
		return rowDeleted;
	}

	@Override
	public boolean editNote(NotesModel notesModel) throws SQLException {
		// TODO Auto-generated method stub
		boolean rowUpdated;
		java.util.Date date =new java.util.Date();
		java.sql.Date sqlDate =new java.sql.Date(date.getTime());

		PreparedStatement preparedStatement = ConnectDatabase.getConnection()
											  .prepareStatement(ConnectDatabase.UPDATE_NOTE_SQL);
		preparedStatement.setString(1, notesModel.getTitle());
		preparedStatement.setString(2, notesModel.getUsername());
		preparedStatement.setString(3, notesModel.getDescription());
		preparedStatement.setDate(4, sqlDate);
		preparedStatement.setString(5, notesModel.getStatus());
		preparedStatement.setLong(6, notesModel.getId());
		
		rowUpdated = preparedStatement.execute();
		return rowUpdated;
	}
}
