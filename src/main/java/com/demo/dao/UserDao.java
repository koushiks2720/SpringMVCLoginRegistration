package com.demo.dao;

import com.demo.model.Login;
import com.demo.model.User;

public interface UserDao {
public void register(User user);
public User validateUser(Login login);
}
