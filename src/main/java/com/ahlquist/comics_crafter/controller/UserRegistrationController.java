package com.ahlquist.comics_crafter.controller;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ahlquist.comics_crafter.dto.UserRegistrationDto;
import com.ahlquist.comics_crafter.model.User;
import com.ahlquist.comics_crafter.service.UserService;

/*
 * This is the user registration controller. It protects the user class, and allows for 
 * the user to register to the site. It has a method which checks if a user 
 * is already registered with an e-mail, and prevents duplicate emails from registering
 * under separate accounts.
 */
@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

   @Autowired
   private UserService userService;

   @ModelAttribute("user")
   public UserRegistrationDto userRegistrationDto() {
       return new UserRegistrationDto();
   }

   @GetMapping
   public String showRegistrationForm(Model model) {
       return "registration";
   }

   @PostMapping
   public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto, BindingResult result){

       User existing = userService.findByEmail(userDto.getEmail());
       if (existing != null){
           result.rejectValue("email", null, "There is already an account registered with that email");
       }

       if (result.hasErrors()){
           return "registration";
       }

       userService.save(userDto);
       return "redirect:/registration?success";
   }
}