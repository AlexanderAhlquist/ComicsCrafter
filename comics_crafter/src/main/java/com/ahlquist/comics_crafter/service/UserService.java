package com.ahlquist.comics_crafter.service;

import java.util.List;

import com.ahlquist.comics_crafter.model.User;

public interface UserService {
	List<User> getAllUsers();
	void saveUser(User user);
	User getUserById(Long user_id);
	void deleteUserById(Long user_id);
}
