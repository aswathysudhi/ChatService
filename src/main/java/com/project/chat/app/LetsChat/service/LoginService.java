package com.project.chat.app.LetsChat.service;

import com.project.chat.app.LetsChat.Data.LoginDetails;
import com.project.chat.app.LetsChat.Data.UserDetails;

public interface LoginService {
	public LoginDetails loadUserByUsername(String username, String password);
	public void registerUser(LoginDetails loginDetails);
	public boolean usernameExists(String username);

    UserDetails getUserByName(String name);
}
