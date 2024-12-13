package com.example.vra.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.vra.entity.User;
import com.example.vra.enums.UserRole;
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

	public UserResponse register(UserRequest userRequest, UserRole role) {
		User user = userMapper.mapToUser(userRequest, new User());
		user.setRole(role);
		user = userRepository.save(user);
		return userMapper.mapToUserResponse(user);

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

	public UserResponse updateUser (UserRequest userRequest, int userId) {
		Optional<User> optional = userRepository.findById(userId);
		if (optional.isPresent()) {
			User exUser  = optional.get();
			User updatedUser  = userMapper.mapToUser(userRequest, exUser);
			User savedUser  = userRepository.save(updatedUser );
			UserResponse response = userMapper.mapToUserResponse(savedUser);
			this.setProfilePictureURL(response, userId);
			return response;
		} else {
			throw new UserNotFoundByIdException("User  not found by given id");
		}
	}
}