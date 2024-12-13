package com.example.vra.service;

import org.springframework.stereotype.Service;

import com.example.vra.entity.User;
import com.example.vra.exception.UserNotFoundByIdException;
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

	public UserResponse getUserById(int userId) {
		User user = userRepository.findById(userId)
		.orElseThrow(()-> new UserNotFoundByIdException("User not found by given id"));
		UserResponse response = userMapper.mapToUserResponse(user);
		this.setProfilePictureURL(response, userId);
		return response;
	}
	
	private void setProfilePictureURL( UserResponse userResponse,int userId) {
		int imageId=userRepository.findImageIdByUserId(userId);
		if(imageId>0) {
			userResponse.setProfilePictureLink("/find-image-by-id?imageId=" + imageId);
		}
	}
}