package com.ahlquist.comics_crafter.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ahlquist.comics_crafter.dto.UserRegistrationDto;
import com.ahlquist.comics_crafter.model.Role;
import com.ahlquist.comics_crafter.model.User;
import com.ahlquist.comics_crafter.repository.UserRepository;
/*
 * implements user service allowing for CRUD operations on the service level
 */
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	  private BCryptPasswordEncoder passwordEncoder;
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
	   public User findByEmail(String email){
	       return userRepository.findByEmail(email);
	   }

	   public User save(UserRegistrationDto registration){
	       User user = new User();
	       user.setUsername(registration.getUsername());
	       user.setEmail(registration.getEmail());
	       user.setPassword(passwordEncoder.encode(registration.getPassword()));
	       user.setRoles(Arrays.asList(new Role("ROLE_USER")));
	       return userRepository.save(user);
	   }

	   @Override
	   public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	       User user = userRepository.findByEmail(email);
	       if (user == null){
	           throw new UsernameNotFoundException("Invalid username or password.");
	       }
	       return new org.springframework.security.core.userdetails.User(user.getEmail(),
	               user.getPassword(),
	               mapRolesToAuthorities(user.getRoles()));
	   }

	   private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
	       return roles.stream()
	               .map(role -> new SimpleGrantedAuthority(role.getName()))
	               .collect(Collectors.toList());
	   }
}
