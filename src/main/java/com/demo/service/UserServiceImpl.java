package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.dao.UserDao;
import com.demo.model.Login;
import com.demo.model.User;

public class UserServiceImpl implements UserService {
  @Autowired
	UserDao userDao;
	
	public void register(User user) {
		userDao.register(user);

	}

	
	public User validateUser(Login login) {
		
		return userDao.validateUser(login);
	}

}
