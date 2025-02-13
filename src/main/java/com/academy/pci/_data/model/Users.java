package com.academy.pci._data.model;

public class Users {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	
	//constructor
	public Users () {
		
	}
	
public Users (int id, String firstName, String lastName, String email, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
	
	
	//accessors and mutators
	public void setId (int id) {
		this.id = id;
	}
	
	public int getId () {
		return id;
	}
	
	
}
