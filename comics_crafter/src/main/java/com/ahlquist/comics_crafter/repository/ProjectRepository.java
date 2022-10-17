package com.ahlquist.comics_crafter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ahlquist.comics_crafter.model.Project;
//This is the Project Repository
@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>{

}
