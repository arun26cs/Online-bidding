package com.onlinebid.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onlinebid.model.User;

@Controller
public class UserFrontController {

	@GetMapping(value = "/")
	public String userHome() {
		
		System.out.println("hi");
		return "index.html";
	}
	
	@GetMapping(value = "/userRegister")
	public String userRegister() {
		return "userRegister";
	}
	
	@ModelAttribute("user")
	public User userConstruct() {
		return new User();
	}
	
}
