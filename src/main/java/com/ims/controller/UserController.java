package com.ims.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ims.model.User;
import com.ims.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService _userService;
	
	//list of users
	@GetMapping("/")
	public String HomePage(Model model) {
		model.addAttribute("listUsers", _userService.GetAllUsers() );
		return "index";
	}
	
	@GetMapping("/CreateNewUser")
	public String CreateNewUser(Model model) {
		//creating an user
		User user = new User();
		model.addAttribute("user",user);
		return "UserForm";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user) {
		// save employee to database
		_userService.CreateUser(user);
		return "redirect:/";
	}
	
	@GetMapping("/UpdateUser/{id}")
	public String UpdateUser(@PathVariable ( value = "id") long id, Model model) {
		
		User user = _userService.GetUserByID(id);
		model.addAttribute("user", user);
		return "UpdateUser";
	}
}
