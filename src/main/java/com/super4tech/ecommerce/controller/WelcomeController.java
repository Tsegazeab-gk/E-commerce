package com.super4tech.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	
	@GetMapping("/welcome")
	public String greet(Model model) {
		model.addAttribute("firstName", "Group 3 project");
		return "index";
	}

}
