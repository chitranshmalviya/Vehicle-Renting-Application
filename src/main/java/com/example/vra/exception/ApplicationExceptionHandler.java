package com.example.vra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.vra.util.ErrorStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleUserNotFoundById(UserNotFoundByIdException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(),ex.getMessage(),
						"user not found by the given id"));
	}
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleFailedToUploadImage(FailedToUploadImageException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(),ex.getMessage(),
						"Failed To Upload Image"));
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleImageNotFoundById(ImageNotFoundByIdException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(),ex.getMessage(),
						"Failed To Find Image"));
	}
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleVehicleNotFoundById(VehicleNotFoundByIdException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(),ex.getMessage(),
						"Failed To Find Vehicle By Give id"));
	}
}
