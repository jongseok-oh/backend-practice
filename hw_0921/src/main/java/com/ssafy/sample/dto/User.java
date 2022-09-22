package com.ssafy.sample.dto;

public class User {
	private String userId;
	private String name;
	private String passWord;
	public User(String userId, String name, String passWord) {
		super();
		this.userId = userId;
		this.name = name;
		this.passWord = passWord;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
}
