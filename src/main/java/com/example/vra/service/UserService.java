package com.example.vra.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.vra.entity.Image;
import com.example.vra.entity.User;
import com.example.vra.exception.FailedToUploadImageException;
import com.example.vra.exception.UserNotFoundByIdException;
import com.example.vra.repository.ImageRepository;
import com.example.vra.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final ImageRepository imageRepository; 

	public UserService(UserRepository userRepository, ImageRepository imageRepository) {
		super();
		this.userRepository = userRepository;
		this.imageRepository = imageRepository;
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public void addUserProfilePicture(int userId, MultipartFile file) {
		Optional<User> optional = userRepository.findById(userId);
		if (optional.isPresent()) {
			User user = optional.get();
			Image image = getImage(file);
			image = imageRepository.save(image);
			user.setImage(image);
			userRepository.save(user);
		} else {
			throw new UserNotFoundByIdException("User Not Found By Given Id");
		}

	}

	public Image getImage(MultipartFile file) {
		Image image = new Image();
		try {
			byte[] imageBytes = file.getBytes();
			image.setContentType(file.getContentType());
			image.setImageBytes(imageBytes);
		} catch (IOException e) {
			throw new FailedToUploadImageException("Failed to upload the image");
		}
		return image;
	}
}
