package com.example.notes;

import java.sql.SQLException;
import java.util.List;

public interface NotesDao {
	
	
	void insertNote(NotesModel note) throws SQLException;
	
	NotesModel selectNote(String username);
	
	List<NotesModel> selectAllNotes(String username);
	
	boolean deleteNote(int id) throws SQLException;
	
	boolean updateNote(NotesModel note) throws SQLException;

}
