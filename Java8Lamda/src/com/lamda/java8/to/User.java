package com.lamda.java8.to;

public class User {
	private int userId;
	private String firstName;
	private String userName;

	public User(int userId,String firstName, String userName) {
		this.userId= userId;
		this.firstName = firstName;
		this.userName =userName; 
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", userName=" + userName + "]";
	}

}
