package com.example.vra.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.vra.requestdto.UserRequest;
import com.example.vra.responsedto.UserResponse;
import com.example.vra.service.UserService;
import com.example.vra.util.ResponseStructure;

@RestController
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/registration")
	public ResponseEntity<ResponseStructure<UserResponse>> saveUser(@RequestBody UserRequest userRequest){
		UserResponse response = userService.saveUser(userRequest);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ResponseStructure.create(HttpStatus.CREATED.value(),"User-Created", response));
	}
	
	@GetMapping("/get-user-by-id") 
    public ResponseEntity<ResponseStructure<UserResponse>> getUserById(@RequestParam("userId") int userId){
         UserResponse response = userService.getUserById(userId);
    	return ResponseEntity.status(HttpStatus.FOUND)
    			.body(ResponseStructure.create(HttpStatus.FOUND.value(),"User-Found ", response));
    }


}