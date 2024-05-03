package com.ryan.gameWorkshopJava.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginUser {

// No Table in SQL. Just for Validation.	
	@NotBlank(message="Email is requred.")
	@Email(message="Email must be in standard format.")
	private String email;
	
	@NotBlank(message="Password is required.")
	@Size(min=8, message="Password must be at least 8 characters.")
	private String password;

// Empty Constructor
	public LoginUser () {}
	
// End
	
// Getters and Setters
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

// End
}
