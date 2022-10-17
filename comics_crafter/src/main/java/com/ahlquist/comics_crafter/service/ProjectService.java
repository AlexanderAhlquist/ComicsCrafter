package com.ahlquist.comics_crafter.service;

import java.util.List;

import com.ahlquist.comics_crafter.model.Project;
/*
 * This is the service interface for the project table.
 */
public interface ProjectService {
	List<Project> getAllProjects();
 	void saveProject(Project project);
 	Project getProjectById(Integer project_id);
 	void deleteProjectById(Integer project_id);
}
