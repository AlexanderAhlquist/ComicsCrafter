package com.ahlquist.comics_crafter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ahlquist.comics_crafter.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/userlist")
	public String viewHomePage(Model model) {
		model.addAttribute("userList", userService.getAllUsers());
		return "userlist";
  }
}
