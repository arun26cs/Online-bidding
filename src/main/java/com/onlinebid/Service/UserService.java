package com.onlinebid.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebid.Exception.DataNotFoundException;
import com.onlinebid.Repository.UserRepository;
import com.onlinebid.model.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUser(){
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}
	
	public User getByUser(String id) {
		return userRepository.findById(id).orElseThrow(()->new DataNotFoundException("User is not found"));
		 
		
	}
	
	public void addUser(User user) {
		 try{
			 userRepository.save(user);
		 }catch(Exception exp) {
			 System.out.println("in throws");
			 throw(exp);
		 }
	}
	
	public void updateUser(User user) {
		User foundUser = userRepository.findById(user.getUserid()).get();
		foundUser= user;
		userRepository.save(foundUser);
	}
	
	public void deleteUser(String id) {
		userRepository.deleteById(id);
	}
}
