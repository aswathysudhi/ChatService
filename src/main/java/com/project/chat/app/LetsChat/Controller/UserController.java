package com.project.chat.app.LetsChat.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.chat.app.LetsChat.Data.UserDetails;
import com.project.chat.app.LetsChat.service.UserService;

@RestController
public class UserController {
 
	@Autowired
	UserService userService;
	
	
	@GetMapping("/getAllUsers")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<UserDetails> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/getAllUsers/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Optional<UserDetails> getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}
	
}
