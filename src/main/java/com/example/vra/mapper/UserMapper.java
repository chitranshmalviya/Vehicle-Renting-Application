package com.example.vra.mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.vra.entity.User;
import com.example.vra.requestdto.UserRequest;
import com.example.vra.responsedto.UserResponse;

@Component
public class UserMapper {

	public User mapToUser(UserRequest request) {
		User user = new User();
		user.setUsername(request.getUsername());
		user.setEmail(request.getEmail());
		user.setPhoneNumber(request.getPhoneNumber());
		user.setPassword(request.getPassword());
		user.setRole(request.getRole());
		return user;
	}

	public UserResponse mapTouserResponse(User user) {
		UserResponse response = new UserResponse();
		response.setUserId(user.getUserId());
		response.setUsername(user.getUsername());
		response.setEmail(user.getEmail());
		response.setPhoneNumber(user.getPhoneNumber());
		response.setRole(user.getRole());
		return response;
	}
}
