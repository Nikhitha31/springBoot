package com.login.loginpage.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.login.loginpage.controller.model.User;
import com.login.loginpage.exception.UserServiceException;

@Service
public interface UserService {

	 List<User> getAllUsers() throws UserServiceException;
	 User getUser(int id) throws UserServiceException;
	 User addUser(User user) throws UserServiceException;
	 User updateUser(String username, User user) throws UserServiceException;
	 void deleteUser(int id) throws UserServiceException;
}
