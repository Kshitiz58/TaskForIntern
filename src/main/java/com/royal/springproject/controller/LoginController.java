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
public class LoginController {

	@Autowired
	private UserRepository userRepo;

	@GetMapping({ "/", "/login" })
	public String Login() {
		return "Login";
	}

	@PostMapping("/login")
	public String loginUser(@ModelAttribute User user, Model model) {
		
		User usr = userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		if(usr != null) {
			model.addAttribute("uname",user.getName());
			return "Home";
		}
		model.addAttribute("message","User not Found!");
		return "Login";
	}
	@GetMapping("/logout")
	public String logout() {
		
		return "Login";
	}
}
