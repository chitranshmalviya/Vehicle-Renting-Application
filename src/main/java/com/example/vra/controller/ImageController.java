package com.example.vra.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.vra.service.ImageService;
import com.example.vra.util.SimpleResponseStructure;

@RestController
public class ImageController {
	
	private final ImageService imageService;
	
	public ImageController(ImageService imageService) {
		super();
		this.imageService = imageService;
	}

	@PostMapping("/add-user-profile-picture")
	public ResponseEntity<SimpleResponseStructure> addUserProfilePicture
	(@RequestParam("userId") int userId, @RequestParam("file") MultipartFile file ){
		imageService.addUserProfilePicture(userId, file);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(SimpleResponseStructure.create(HttpStatus.CREATED.value(),"User-Created"));
	}
	
}
