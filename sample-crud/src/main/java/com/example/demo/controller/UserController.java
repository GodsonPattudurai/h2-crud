package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping(value = "/user-list")
	public List<User> findUserList() {
		return userService.findUserList();
	}	
	
	@PostMapping("/saveUser")
	public User createOrSaveEmployee(@RequestBody User userDTO) {
        return userService.saveOrUpdateUser(userDTO);
    }
	
	@PutMapping("/updateUser/{id}")
	public User updateEmployee(@RequestBody User userDTO, @PathVariable Long id) {
		userDTO.setId(id);
		return userService.saveOrUpdateUser(userDTO);
    }
 
    @DeleteMapping("/deleteUser/{id}")
    public String deleteEmployee(@PathVariable Long id) {
    	userService.deleteUserById(id);
    	return "SUCCESS";
    }
}
