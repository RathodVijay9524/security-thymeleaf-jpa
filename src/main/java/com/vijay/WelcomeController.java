package com.vijay;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class WelcomeController {
	
	
	@GetMapping("/welcome")
	public String getWelcome() {
		return "welcome";
	}
	
	
	@GetMapping("/login")
	public String getLoginPage() {
		return "login";
	}
	@PostMapping("/login")
	public String getLogin() {
		return "welcome";
	}
	
	

}
