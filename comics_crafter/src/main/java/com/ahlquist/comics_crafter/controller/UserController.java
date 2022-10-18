package com.ahlquist.comics_crafter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ahlquist.comics_crafter.model.Project;
import com.ahlquist.comics_crafter.model.User;
import com.ahlquist.comics_crafter.service.ProjectService;
import com.ahlquist.comics_crafter.service.UserService;
/*
 * This controller deals with the User table in the Comics Crafter database. 
 * It allows for front end interaction with the database, with each of the 
 * four CRUD operations represented. 
 */
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private ProjectService projectService;

//Read operation for the User table.
	@GetMapping("/user_list")
	public String viewUserList(Model model) {
		model.addAttribute("userList", userService.getAllUsers());
		return "user_list";
  }
//Create operation for the User table.
	@GetMapping("/register_user")
	public String registerUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "new_user";
	}
//Saves the user object to the database.
	@PostMapping("/save_user")
	public String saveUser(@ModelAttribute("user") User user) {
		//save employee to database
		userService.saveUser(user);
		return "redirect:/user_list";
	}
//Update operation for the user table.
	@GetMapping("/user_update/{id}")
	public String userUpdate(@PathVariable(value="id") Long id, Model model) {
		User user = userService.getUserById(id);
		List<Project> listProject = projectService.getAllProjects();
		model.addAttribute("listProject", listProject);
		model.addAttribute("user", user);
		return "update_user";
	}
	
//Delete operation for the user table.
	@GetMapping("/user_delete/{id}")
	public String deleteUser(@PathVariable(value = "id") Long id) {
		this.userService.deleteUserById(id);
		return "redirect:/user_list";
	}
	
	@GetMapping("/user/{id}")
	public String getUserById(@PathVariable(value="id") Long id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		return "user";
	}
}
