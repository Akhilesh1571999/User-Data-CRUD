package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/getAll")
	@PreAuthorize("hasRole('USER')")
	public List<User> getAllUsers(@PathVariable("getAll") User user){
		User saveUser = service.saveUser(user);
		return (List<User>) saveUser;
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('USER')")
	public User getUserById(@PathVariable("id") int userId) {
		User findUserById = service.findUserById(userId);
		return findUserById;
	}
	
//	@GetMapping ("/{id}")
//    @PreAuthorize("hasRole('USER')")
//	public ResponseEntity<User> getUserById(@PathVariable("id") int userId){
//		User findUserById = service.findUserById(userId);
//		return new ResponseEntity<User>(findUserById,HttpStatus.OK);
//	}
//	
//	@GetMapping("/getAll")
//    @PreAuthorize("hasRole('USER')")
//	public List<User> getAllUser(){
//		List<User> findAll = service.findAll();
//		return findAll;
//	}
	
}