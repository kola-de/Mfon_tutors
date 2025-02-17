package com.academy.pci.service;

import java.util.List;

import com.academy.pci._data.model.Users;
import com.academy.pci._data.repository.*;
public class UserServiceImpl implements UserService{

	private static final UserRepository userRepository = new UserRepositoryImpl();
	
	
	@Override
	public Users signUp(Users user) {
		user.setFirstName(user.getFirstName());
		user.setFirstName(user.getFirstName());
		user.setPassword(user.getPassword());
		user.setEmail(user.getEmail());
		
		
		return userRepository.save(user);
	}

	@Override
	public Users logIn(String email, String password) {
		Users user = userRepository.findByEmail(email.toLowerCase());
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        return userRepository.save(user);
	}

	
	
	@Override
	public void logOut(int id) {
		
		for (Users user : userRepository.findAll()) {
	           user.setLoggedIn(false);
	           userRepository.save(user);
	       }
	}

	@Override
	public void deleteUser(Users user) {
		userRepository.delete(user);
		
	}

	@Override
	public List<Users> getAllUsers() {
		
		return userRepository.findAll();
		
	}
}
