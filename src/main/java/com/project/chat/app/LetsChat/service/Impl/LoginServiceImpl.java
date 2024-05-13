package com.project.chat.app.LetsChat.service.Impl;

import com.project.chat.app.LetsChat.Data.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.chat.app.LetsChat.Dao.LoginDao;
import com.project.chat.app.LetsChat.Data.LoginDetails;
import com.project.chat.app.LetsChat.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private LoginDao loginDao;


	@Override
	public void registerUser(LoginDetails loginDetails) {
		String hashedPassword = passwordEncoder.encode(loginDetails.getPassword());
		loginDetails.setPassword(hashedPassword);
        loginDao.registerNewUser(loginDetails);

	}

	@Override
	public boolean usernameExists(String username) {
		LoginDetails user = loginDao.findByUsername(username);
        return user != null;
    }

	@Override
	public UserDetails getUserByName(String name) {
		return loginDao.getUserByName(name);
	}

	@Override
	public LoginDetails loadUserByUsername(String username, String password) {
		LoginDetails user = loginDao.findByUsername(username);
		
		if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        
        // Check the hashed password using the PasswordEncoder
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }
        
        // If username and password are valid, you can return a custom UserDetails object or use the User class.
        return new LoginDetails(user.getUsername(), user.getPassword());
	}

}
