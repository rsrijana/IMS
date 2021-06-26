package com.ims.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
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
	public String CreateNewUser( Model model) {
		//creating an user

		User user = new User();
		model.addAttribute("user",user);
		return "UserForm";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@Valid @ModelAttribute("user") User user, Errors errors,Model model) {
		// save employee to database
		 if (null != errors && errors.getErrorCount() > 0) {
			 return "UserForm";
	        }
		 else {
	            model.addAttribute("successMsg", "User created successfully!!");
	            _userService.CreateUser(user);
	            return "success";
	        }
		
	}
	
	@GetMapping("/UpdateUser/{id}")
	public String UpdateUser(@PathVariable ( value = "id") long id, Model model) {
		
		User user = _userService.GetUserByID(id);
		model.addAttribute("user", user);
		return "UpdateUser";
	}
	
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable (value = "id") long id) {
		
		// call delete employee method 
		this._userService.DeleteUser(id);
		return "redirect:/";
	}
}
