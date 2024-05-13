package com.project.chat.app.LetsChat.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.chat.app.LetsChat.Data.UserDetails;
import com.project.chat.app.LetsChat.repository.UserRepository;

@Component
public class UserDao {
	
	@Autowired
	UserRepository userRepository;

	public List<UserDetails> getAll() {
		
		return userRepository.findAll();
	}


	public Optional<UserDetails> getUserById(int id) {
		return userRepository.findById(id);
	}
	
	

}
