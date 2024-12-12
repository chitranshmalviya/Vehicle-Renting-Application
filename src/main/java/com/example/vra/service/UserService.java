package com.example.vra.service;

import org.springframework.stereotype.Service;

import com.example.vra.entity.User;
import com.example.vra.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}



}
