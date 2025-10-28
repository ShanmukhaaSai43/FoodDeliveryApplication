package com.food.dto;

public class User {
	private int userId;
	private String name;
	private String password;
	private String eMail;
	private String address;
	private String role;

	public User() {

	}

	public User(int userId, String name, String password, String eMail, String address, String role) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.eMail = eMail;
		this.address = address;
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", eMail=" + eMail + ", address=" + address + ", role="
				+ role + "]";
	}

}
