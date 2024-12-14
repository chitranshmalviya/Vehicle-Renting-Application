package com.example.vra.exception;

public class BaseException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private final String message;

	public BaseException(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
}
