package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/save")
    @PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<User> createNewUser(@RequestBody User user){
		User saveUser = userService.saveUser(user);
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
	public String updateUserById(@RequestBody User user) {
		int updateUser = userService.updateUser(user.getUser_id(), user);
		if(updateUser == 0) {
			return "user not found";
		}
		return "user updated successfully";
	}
	
	@DeleteMapping ("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
	public String deleteUserById(@PathVariable("id") int userId) {
		String deleteUser = userService.deleteUser(userId);
		return "deleted";
	}

}
