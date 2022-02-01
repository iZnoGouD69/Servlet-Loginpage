package com.example.notes;

import java.sql.SQLException;
import java.util.List;

public interface Notes  {
		
	void insertNote(NotesModel note) throws SQLException;
		
	List<NotesModel> selectAllNotes(String username) throws SQLException;
	
	boolean deleteNote(int id) throws SQLException;

	boolean editNote(NotesModel notesModel) throws SQLException; 
	
}
