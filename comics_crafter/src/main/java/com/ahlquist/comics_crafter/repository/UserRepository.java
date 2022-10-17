package com.ahlquist.comics_crafter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ahlquist.comics_crafter.model.User;
//This is the User Repository.
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
}
