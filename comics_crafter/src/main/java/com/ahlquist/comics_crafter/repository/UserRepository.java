package com.ahlquist.comics_crafter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ahlquist.comics_crafter.model.User;
//This is the User Repository. It allows for CRUD and database operations using 
//JPA repository.
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
//These methods are used in the security operations to ensure that users can log in by email.
	User findByUsername(String username);
	User findByEmail(String email);
}
