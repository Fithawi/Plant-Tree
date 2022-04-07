package com.project.adminportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
@RequestMapping("/")
	public String index() {
		return "redirect:/home";
	}
@RequestMapping("/home")
public String home() {
	return "home";
}
@RequestMapping("login")
public String login() {
	return "login";
}
}
