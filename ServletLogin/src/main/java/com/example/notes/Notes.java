package com.example.notes;

import java.sql.SQLException;
import java.util.List;

public interface Notes  {
		
	void insertNote(NotesModel note) throws SQLException;
	
	NotesModel selectNote(String username) throws SQLException;
	
	List<NotesModel> selectAllNotes(String username) throws SQLException;
	
	boolean deleteNote(int id) throws SQLException;
	
}
