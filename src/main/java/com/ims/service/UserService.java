package com.ims.service;

import java.util.List;

import com.ims.model.User;

public interface UserService{
	List<User> GetAllUsers();
	void CreateUser(User user);
}
