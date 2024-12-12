package com.example.vra.util;

public class SimpleResponseStructure {

	private int status;
	private String messege;

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessege() {
		return messege;
	}
	public void setMessege(String messege) {
		this.messege = messege;
	}

	public static SimpleResponseStructure create(int status, String messege){
		SimpleResponseStructure response = new SimpleResponseStructure();
		response.setStatus(status);
		response.setMessege(messege);
		return response;
}
}
