package com.super4tech.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gethomepage")
public class HomeController {

	// for testing security
//	@RequestMapping
	public String welcome(Model model) {
		model.addAttribute("firstName", "User");
		model.addAttribute("tagline", "The one and only amazing web store");
		return "login";
	}
}
