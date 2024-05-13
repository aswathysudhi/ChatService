package com.project.chat.app.LetsChat.service;

import java.util.List;
import java.util.Optional;

import com.project.chat.app.LetsChat.Data.UserDetails;

public interface UserService {
  public List<UserDetails> getAllUsers();
  public Optional<UserDetails> getUserById(int id);

  
}
