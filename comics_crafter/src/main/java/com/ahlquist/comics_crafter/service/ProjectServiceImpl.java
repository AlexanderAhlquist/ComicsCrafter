package com.ahlquist.comics_crafter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahlquist.comics_crafter.model.Project;
import com.ahlquist.comics_crafter.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService{

		@Autowired
		private ProjectRepository projectRepository;

		@Override
		public List<Project> getAllProjects() {
			return projectRepository.findAll();
		}

		@Override
		public void saveProject(Project project) {
			this.projectRepository.save(project);
			
		}

		@Override
		public Project getProjectById(Integer project_id) {
			Optional<Project> optional = projectRepository.findById(project_id);
			Project project = null;
			if (optional.isPresent()) {
				project = optional.get();
			} else {
				throw new RuntimeException("Project not found");
			}
			return project;
		}

		@Override
		public void deleteProjectById(Integer project_id) {
			this.projectRepository.deleteById(project_id);
			
		}
		
}
