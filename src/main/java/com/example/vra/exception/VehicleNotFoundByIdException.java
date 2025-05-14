package com.example.vra.exception;

public class VehicleNotFoundByIdException extends BaseException {

	private static final long serialVersionUID = 1L;

	public VehicleNotFoundByIdException(String message) {
		super(message);
	}
}
