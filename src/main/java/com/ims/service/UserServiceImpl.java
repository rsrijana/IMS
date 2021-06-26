package com.ims.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public User GetUserByID(long userID) {
		// TODO Auto-generated method stub
		Optional<User> optional =_userRepository.findById(userID);
		User user = null;
		if(optional.isPresent()) {
			user = optional.get();
		}
		else {
			throw new RuntimeException("User not found with this id : " + userID);
		}
		return user;
	}

	@Override
	public void DeleteUser(long id) {
		// TODO Auto-generated method stub
		this._userRepository.deleteById(id);
	}
	
}
