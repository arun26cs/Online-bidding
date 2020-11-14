package com.onlinebid.Controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.RestController;

import com.onlinebid.Service.UserService;
import com.onlinebid.model.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<User> getAllUser() {
		return userService.getAllUser();
	}
	
	@RequestMapping(method=RequestMethod.GET ,value="/{id}")
	public User getUser(@PathVariable("id") String id) {
		User user = userService.getByUser(id);
		return user;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public void updateUser(@RequestBody User user) {
		userService.updateUser(user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{id}")
	public void deleteUser(@PathVariable("id") String id) {
		userService.deleteUser(id);
	}
	
	
}
