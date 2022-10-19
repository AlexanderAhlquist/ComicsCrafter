package com.ahlquist.comics_crafter.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.ahlquist.comics_crafter.dto.UserRegistrationDto;
import com.ahlquist.comics_crafter.model.User;
/*
 * This is the service interface for the user table.
 */
public interface UserService extends UserDetailsService{
	List<User> getAllUsers();
	void saveUser(User user);
	User getUserById(Long user_id);
	void deleteUserById(Long user_id);
	User save(UserRegistrationDto registration);
	User findByEmail(String email);

}
