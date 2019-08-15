package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;

@Service
public interface UserService {
	
	List<User> findUserList();
	
	User saveOrUpdateUser(User userDto);
	
	void deleteUserById(Long id);	

}
