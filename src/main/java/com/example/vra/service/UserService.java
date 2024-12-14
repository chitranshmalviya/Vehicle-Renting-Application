package com.example.vra.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.vra.entity.Image;
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
		this.setProfilePictureURL(response, user.getImage());
		return response;
	}

	private void setProfilePictureURL( UserResponse userResponse, Image profilePicture) {
		if(profilePicture!=null) {
			userResponse.setProfilePictureLink("/find-image-by-id?imageId=" + profilePicture.getImageId());
		}
	}

	public UserResponse updateUser (UserRequest userRequest, int userId) {
		Optional<User> optional = userRepository.findById(userId);
		if (optional.isPresent()) {
			User exUser  = optional.get();
			User updatedUser  = userMapper.mapToUser(userRequest, exUser);
			User savedUser  = userRepository.save(updatedUser );
			UserResponse response = userMapper.mapToUserResponse(savedUser);
			this.setProfilePictureURL(response, exUser.getImage());
			return response;
		} else {
			throw new UserNotFoundByIdException("User  not found by given id");
		}
	}
}