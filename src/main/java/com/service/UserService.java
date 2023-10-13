package com.service;

import java.util.List;

import com.model.User;


public interface UserService {
	
	User saveUser(User user);
	
	User findUserById(int userId);
	
	List<User> findAll();
	
	int updateUser(int userId,User user);
	
	String deleteUser(int userId);

}
