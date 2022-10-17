package com.ahlquist.comics_crafter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ahlquist.comics_crafter.model.Project;
import com.ahlquist.comics_crafter.service.ProjectService;

@Controller
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/project_list")
	public String viewProjectList(Model model) {
		model.addAttribute("projectList", projectService.getAllProjects());
		return "project_list";
	}
	
	@GetMapping("/create_project")
	public String createProject(Model model) {
		Project project = new Project();
		model.addAttribute("project", project);
		return "new_project";
	}
	@PostMapping("/save_project")
	public String saveProject(@ModelAttribute("project") Project project) {
		projectService.saveProject(project);
		return "redirect:/project_list";
	}
	@GetMapping("/project_update/{id}")
	public String projectUpdate(@PathVariable(value="id") Integer id, Model model) {
		Project project = projectService.getProjectById(id);
		model.addAttribute("project", project);
		return "update_project";
	}
	@GetMapping("/project_delete/{id}")
	public String projectDelete(@PathVariable(value="id") Integer id) {
		this.projectService.deleteProjectById(id);
		return "redirect:/project_list";
	}
}
