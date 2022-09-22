package com.ssafy.sample.model.service;

import com.ssafy.sample.dto.User;
import com.ssafy.sample.model.dao.UserDao;

public class UserService {
	private UserDao userDao = new UserDao();
	
	public boolean createUser(User user) {
		return userDao.insertUser(user) != 0;
	}
	
	public User getUser(String userId) {
		return userDao.selectUser(userId);
	}
	
	public boolean checkUserValidation(String userId, String passWord){
		User user = getUser(userId);
		if(user != null) {
			return user.getPassWord().equals(passWord); 
		}
		return false;
	}
}