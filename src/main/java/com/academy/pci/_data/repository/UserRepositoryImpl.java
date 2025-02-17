package com.academy.pci._data.repository;

import java.util.ArrayList;
import java.util.List;
import com.academy.pci._data.model.Users;

public class UserRepositoryImpl implements UserRepository {

	private final List<Users> userList = new ArrayList<>();

	@Override
	public Users save(Users user) {
		if (user == null) {

			throw new RuntimeException("User cannot be null");
		}
		userList.add(user);
		return user;
	}

	@Override
	public void delete(Users user) {
		if (user == null) {
			throw new RuntimeException("User cannot be null");
		}

		userList.remove(user);
	}

	@Override
	public Users findById(int id) {
		for (Users user : userList) {

			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	@Override
	public List<Users> findAll() {
		return new ArrayList<>(userList);

	}

	@Override
	public Users findByEmail(String email) {
		
		for (Users users: userList){
            if(users.getEmail().equalsIgnoreCase(email)){
                return users;
            }
        }
        return null;
	}

}
