package com.project.chat.app.LetsChat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.chat.app.LetsChat.Data.LoginDetails;

public interface LoginRepository extends JpaRepository<LoginDetails, Integer>{
	
	LoginDetails findByUsername(String username);

}
