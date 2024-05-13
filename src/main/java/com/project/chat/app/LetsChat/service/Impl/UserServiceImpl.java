package com.project.chat.app.LetsChat.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.chat.app.LetsChat.Dao.UserDao;
import com.project.chat.app.LetsChat.Data.UserDetails;
import com.project.chat.app.LetsChat.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	
	@Override
	public List<UserDetails> getAllUsers() {
		
		return userDao.getAll();
	}

	@Override
	public Optional<UserDetails> getUserById(int id) {
		
		return userDao.getUserById(id);
	}

	

}
