package com.project.chat.app.LetsChat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.chat.app.LetsChat.Data.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, Integer> {

}
