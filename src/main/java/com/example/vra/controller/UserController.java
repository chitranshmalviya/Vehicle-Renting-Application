package com.example.vra.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.vra.service.UserService;

@RestController
public class UserController {
	
	private final UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	

}
