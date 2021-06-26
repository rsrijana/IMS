package com.ims.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.repository.IUserRepository;
import com.ims.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private IUserRepository _userRepository;

	@Override
	public List<User> GetAllUsers() {
		// TODO Auto-generated method stub
		return _userRepository.findAll();
	}

	@Override
	public void CreateUser(User user) {
		// TODO Auto-generated method stub
		this._userRepository.save(user);
	}
	
}
