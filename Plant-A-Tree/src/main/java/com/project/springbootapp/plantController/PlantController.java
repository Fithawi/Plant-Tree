package com.project.springbootapp.plantController;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.springbootapp.service.UserService;
import com.project.springbootapp.service.impl.UserSecurityService;
import com.project.springbootapp.user.User;
import com.project.springbootapp.user.security.PasswordResetToken;

@Controller

public class PlantController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserSecurityService userSecurityService;
	@GetMapping("/")
public String IndexPage() {
	
	return "index";
}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("classActiveLogin",true);
	return "myAccount";
	}
	@GetMapping("/forgetPassword")
	public String forgetPassword(
			Model model) {
	
		model.addAttribute("classActiveForgetPassword",true);
	return "myAccount";
	}
	@GetMapping("/newUser")
	public String newAccount(Locale locale, 
			@RequestParam("token") String token,Model model) {
		PasswordResetToken passToken= userService.getPasswordResetToken(token);
		
		if (passToken == null) {
			String message = "Invalid Token.";
			model.addAttribute("message", message);
			return "redirect:/badRequest";
		}
		User user = passToken.getUser();
		String username = user.getUsername();

		UserDetails userDetails = userSecurityService.loadUserByUsername(username);
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(),
				userDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		model.addAttribute("classActiveEdit",true);
	return "myProfile";
	}
		
}
