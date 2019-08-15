package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.UserService;

@Component
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> findUserList() {
		return userRepository.findAll();
	}

	@Override
	public User saveOrUpdateUser(User userDto) {
		return userRepository.save(userDto);
	}

	@Override
	public void deleteUserById(Long id) {
		User user = userRepository.findUserById(id);
		userRepository.delete(user);
	}

}
