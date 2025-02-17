package com.academy.pci.service;

import java.util.List;

import com.academy.pci._data.model.Users;

public interface UserService {

	Users signUp (Users user);
	
	Users logIn (String email, String password);
	
	void logOut (int id);
	
	void deleteUser(Users user);
	
    List<Users> getAllUsers();
}
