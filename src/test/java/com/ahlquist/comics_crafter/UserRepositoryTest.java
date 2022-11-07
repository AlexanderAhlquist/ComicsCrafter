package com.ahlquist.comics_crafter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.ahlquist.comics_crafter.model.User;
import com.ahlquist.comics_crafter.repository.UserRepository;

@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void userRepositoryTests() {
		User user = new User();
		user.setUsername("Tester");
		user.setEmail("Test@test.com");
		user.setPassword("testPassword");
		userRepository.save(user);
		user = userRepository.findByUsername("Tester");
		assertTrue(user.getUsername().equals("Tester"));
		assertFalse(user.getUsername().equals("Not Test"));
		user = userRepository.findByEmail("Test@test.com");
		assertTrue(user.getEmail().equals("Test@test.com"));
		assertFalse(user.getEmail().equals("NotTest"));
	}
	@AfterEach
	public void deleteTest() {
		User user = userRepository.findByEmail("Test@test.com");
		userRepository.deleteById(user.getUser_id());
	}
}
