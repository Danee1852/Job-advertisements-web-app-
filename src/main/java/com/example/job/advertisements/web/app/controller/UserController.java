package com.example.job.advertisements.web.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.job.advertisements.web.app.model.User;
import com.example.job.advertisements.web.app.service.UserService;


@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	//new function
	@PostMapping("/users/save")
	public String saveUser(User user, RedirectAttributes ra) {
		service.save(user);
		ra.addFlashAttribute("message", "User has been created Successfuly.");
		return "";
	}
}
