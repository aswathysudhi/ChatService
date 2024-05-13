package com.project.chat.app.LetsChat.Dao;

import com.project.chat.app.LetsChat.Data.UserDetails;
import com.project.chat.app.LetsChat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.chat.app.LetsChat.Data.LoginDetails;
import com.project.chat.app.LetsChat.repository.LoginRepository;

@Component
public class LoginDao {
	
	@Autowired
	LoginRepository loginRepo;

	@Autowired
	UserRepository userRepository;

	public void registerNewUser(LoginDetails loginDetails) {
		loginRepo.save(loginDetails);
		
	}

	public LoginDetails findByUsername(String username) {
		// TODO Auto-generated method stub
		return loginRepo.findByUsername(username);
	}


    public UserDetails getUserByName(String name) {
		return userRepository.findByName(name);
    }
}
