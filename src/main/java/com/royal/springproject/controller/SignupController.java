package com.royal.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.royal.springproject.model.User;
import com.royal.springproject.repository.UserRepository;

@Controller
public class SignupController {

	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/signup")
	public String SignupUser() {
		return "Signup";
	}
	
	
	@PostMapping("/signup")
	public String signupUser(@ModelAttribute User user , Model model) {
		userRepo.save(user);
	
		model.addAttribute("uname", user.getUsername());
		
		return "Login";
	}
}
