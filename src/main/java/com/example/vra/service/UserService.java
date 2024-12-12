package com.example.vra.service;

import org.springframework.stereotype.Service;

import com.example.vra.entity.User;
import com.example.vra.mapper.UserMapper;
import com.example.vra.repository.UserRepository;
import com.example.vra.requestdto.UserRequest;
import com.example.vra.responsedto.UserResponse;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final UserMapper userMapper;
	
	public UserService(UserRepository userRepository, UserMapper userMapper) {
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	} 

	public UserResponse saveUser(UserRequest userRepositor) {
		User user = userMapper.mapToUserRequest(userRepositor);
		User savedUser = userRepository.save(user);
		return userMapper.mapToUserResponse(savedUser);
	}
}