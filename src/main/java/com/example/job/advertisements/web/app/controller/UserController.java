package com.example.job.advertisements.web.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.job.advertisements.web.app.DTO.UserRegistrationDto;
import com.example.job.advertisements.web.app.exceptionHandler.UserNotFoundException;
import com.example.job.advertisements.web.app.model.User;
import com.example.job.advertisements.web.app.service.UserService;


@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	//new function
	@PostMapping("/registration")
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		service.create(registrationDto);
		return "redirect:/registration?success";
	}
	@GetMapping("/registration")
	public String showRegistrationForm() {
		return "registration";
	}
	
	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}
	
	@GetMapping("/users/delete/{id}")
	public String deleteUser(@PathVariable long id, RedirectAttributes ra) {
		
		try {
			service.delete(id);
			ra.addFlashAttribute("message", "User has been deleted.");
		}catch (UserNotFoundException e) {
			
			ra.addFlashAttribute("message", e.getMessage());
		}
		return " ";
	}
	
	@GetMapping("/home")
	public String homePage() {
		return "index";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("/register")
	public String registerPage() {
		return "register";
	}
	
	
}
