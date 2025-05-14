package com.example.vra.exception;

public class UserNotFoundByIdException extends BaseException {
	private static final long serialVersionUID = 1L;

	public UserNotFoundByIdException(String message) {
		super(message);
	}

}