package com.example.vra.util;

public class ResponseStructure<T> {

	private int status;
	private String messege;
	private T data;

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
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

	public static <T> ResponseStructure<T> create(int status, String messege, T data){
		ResponseStructure<T> response = new ResponseStructure<T>();
		response.setStatus(status);
		response.setMessege(messege);
		response.setData(data);
		return response;
	}
}