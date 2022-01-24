package com.example.registration;


public class RegistrationValidator {
	
	public static void main(String[] args) {
		System.out.println(containsLower("abc"));
		System.out.println(containsUpper("ABC"));
		System.out.println(containsDigit("123"));
	} 
	
	public static String validate(String password, String message) {
		
		if(!containsLower(password)) {
			if(message == null) {
				message = "Password should contain lower case";
			} else {
				message = "Password should contain lower case,";
			}
		} 
		
		if(!containsUpper(password)) {
			if(message == null) {
				message = "Password should contain upper case";
			} else {
				message += ", upper case";
			}
		}
		
		if(!containsDigit(password)) {
			if(message == null) {
				message = "Password should contain digit";
			} else {
				message += ", digit";
			}
		}
	
		return message;
	}

	
	public static boolean containsLower(String password) {
		if(password.matches(".*[a-z].*")) {
			return true;
		} 
		return false;
	}
	
	public static boolean containsUpper(String password) {
		if(password.matches(".*[A-Z].*")) {
			return true;
		}
		return false;
	}
	
	public static boolean containsDigit(String password) {
		if(password.matches(".*[0-9].*")) {
			return true;
		} 
		return false;
	}
	
}
