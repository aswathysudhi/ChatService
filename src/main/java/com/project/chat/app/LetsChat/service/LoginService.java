package com.project.chat.app.LetsChat.service;

import com.project.chat.app.LetsChat.Data.LoginDetails;
import com.project.chat.app.LetsChat.Data.UserDetails;

public interface LoginService {
	 LoginDetails loadUserByUsername(String username, String password);
	 void registerUser(LoginDetails loginDetails);
	 boolean usernameExists(String username);
	 UserDetails getUserByName(String name);
}
