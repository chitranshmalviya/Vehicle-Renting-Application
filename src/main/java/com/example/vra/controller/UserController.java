package com.example.vra.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.vra.entity.User;
import com.example.vra.service.UserService;
import com.example.vra.util.ResponseStructure;
import com.example.vra.util.SimpleResponseStructure;

@RestController
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/registration")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user){
		user = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ResponseStructure.create(HttpStatus.CREATED.value(),"User-Created", user));
	}

	@PostMapping("/add-user-profile-picture")
	public ResponseEntity<SimpleResponseStructure> addUserProfilePicture
	(@RequestParam("userId") int userId, @RequestParam("file") MultipartFile file ){
		userService.addUserProfilePicture(userId, file);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(SimpleResponseStructure.create(HttpStatus.CREATED.value(),"User-Created"));
	}
}