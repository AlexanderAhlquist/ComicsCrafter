package com.ahlquist.comics_crafter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ahlquist.comics_crafter.model.User;
import com.ahlquist.comics_crafter.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/user_list")
	public String viewHomePage(Model model) {
		model.addAttribute("userList", userService.getAllUsers());
		return "user_list";
  }
	
	@GetMapping("/register_user")
	public String showNewEmployeeForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "new_user";
	}
	
	@PostMapping("/save_user")
	public String saveUser(@ModelAttribute("user") User user) {
		//save employee to database
		userService.saveUser(user);
		return "redirect:/user_list";
	}
	@GetMapping("/user_update/{id}")
	public String userUpdate(@PathVariable(value="id") Long id, Model model) {
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "update_user";
	}
	@GetMapping("/user_delete/{id}")
	public String deleteEmployee(@PathVariable(value = "id") Long id) {
		this.userService.deleteUserById(id);
		return "redirect:/user_list";
	}
}
