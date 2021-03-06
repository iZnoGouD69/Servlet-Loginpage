package com.example.notes;

import java.time.LocalDate;

public class NotesModel {
	
	private long id;
	private String title;
	private String username;
	private String description;
	private LocalDate targetDate;
	private String status;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public String getStatus() {
		return status;
	}

	public String setStatus(String status) {
		return this.status = status;
	}

	
	
	protected NotesModel(){
		
	}
	
	 public NotesModel(long id, String title, String username, String description, LocalDate targetDate, String isDone) {
	        super();
	        this.id = id;
	        this.title = title;
	        this.username = username;
	        this.description = description;
	        this.targetDate = targetDate;
	        this.status = isDone;
	    }
	 
	 public NotesModel(String title, String username, String description, LocalDate targetDate, String isDone) {
	        super();
	        this.title = title;
	        this.username = username;
	        this.description = description;
	        this.targetDate = targetDate;
	        this.status = isDone;
	    }
	 
	 @Override
	 public int hashCode() {
		 final int prime = 31;
		 int result = 1;
		 result = prime * result + (int) (id ^ (id >>> 32));
		 return result;
	 }
	 
	 @Override
	 public boolean equals(Object obj) {
		 if(this == obj) {
			 return true;
		 }
		 if(obj == null) {
			 return false;
		 }
		 if(getClass() != obj.getClass()) {
			 return false;
		 }
		 NotesModel other = (NotesModel) obj;
		 if(id != other.id) {
			 return false;
		 }
		 return true;
	 }	

}
