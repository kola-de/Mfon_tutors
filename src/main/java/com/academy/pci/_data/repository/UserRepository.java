package com.academy.pci._data.repository;

import java.util.List;

import com.academy.pci._data.model.Expenses;
import com.academy.pci._data.model.Users;

public interface UserRepository {

	//create methods
			Users save(Users user);
			
			void delete(Users user);
			
			Users findById(int id);
			
			List<Users> findAll();

			Users findByEmail(String lowerCase);
	
}
