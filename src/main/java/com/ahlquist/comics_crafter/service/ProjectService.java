package com.ahlquist.comics_crafter.service;

import java.util.List;

import com.ahlquist.comics_crafter.model.Project;
/*
 * This is the service interface for the project table.
 */
public interface ProjectService {
	List<Project> getAllProjects();
 	void saveProject(Project project);
 	Project getProjectById(Long project_id);
 	void deleteProjectById(Long project_id);
}
