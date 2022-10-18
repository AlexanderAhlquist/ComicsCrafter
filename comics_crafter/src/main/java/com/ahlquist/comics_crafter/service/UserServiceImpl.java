package com.ahlquist.comics_crafter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahlquist.comics_crafter.model.Project;
import com.ahlquist.comics_crafter.model.User;
import com.ahlquist.comics_crafter.repository.ProjectRepository;
import com.ahlquist.comics_crafter.repository.UserRepository;
/*
 * implements user service allowing for CRUD operations on the service level
 */
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	public void saveUser(User user) {
		this.userRepository.save(user);
	}
	@Override
	public User getUserById(Long user_id) {
		Optional<User> optional = userRepository.findById(user_id);
		User user = null;
		if (optional.isPresent()) {
			user = optional.get();
		}else {
			throw new RuntimeException("User not found");
		}
		return user;
	}
	
	@Override
	public void deleteUserById(Long user_id) {
		this.userRepository.deleteById(user_id);
	}	
}
