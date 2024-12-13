package com.example.vra.responsedto;

import com.example.vra.enums.UserRole;

public class UserResponse {
	private int userId;
	private String username;
	private String email;
	private String phoneNumber;
	private UserRole role;
	private String profilePictureLink;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public UserRole getRole() {
		return role;
	}
	public void setRole(UserRole role) {
		this.role = role;
	}
	public String getProfilePictureLink() {
		return profilePictureLink;
	}
	public void setProfilePictureLink(String profilePictureLink) {
		this.profilePictureLink = profilePictureLink;
	}
}