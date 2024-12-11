package com.example.vra.util;

public class ErrorStructure {

	private int status;
	private String message;
	private String rootCause;

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRootCause() {
		return rootCause;
	}
	public void setRootCause(String rootCause) {
		this.rootCause = rootCause;
	}

	public static ErrorStructure create(int status, String message, String rootCause) {
		ErrorStructure error = new ErrorStructure();
		error.setStatus(status);
		error.setMessage(message);
		error.setRootCause(rootCause);
		return error;
	}
}