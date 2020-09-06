package com.demo.service;

import com.demo.model.Login;
import com.demo.model.User;

public interface UserService {
public void register(User user);
public User validateUser(Login login);
}
