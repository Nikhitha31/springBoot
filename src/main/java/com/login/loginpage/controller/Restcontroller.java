package com.login.loginpage.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.login.loginpage.controller.model.User;
import com.login.loginpage.exception.UserServiceException;
import com.login.loginpage.services.UserService;

@RestController
public class Restcontroller {
	@GetMapping("/")
	public String hello() {
		return "This is home page";
	}

	@Autowired
	private UserService userService;

	@RequestMapping("/users")
	public List<User> getAllUsers() throws UserServiceException {
		return userService.getAllUsers();
	}

	// USe mockMvc to do functional testing from controller till Data
	// base for Data base use HSQL embedded data base
	@RequestMapping("/users/{id}")
	public Object getUser(@PathVariable int id) throws UserServiceException {
		return userService.getUser(id);

	}

	@PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User addUser(@RequestBody User user) throws UserServiceException {
		return userService.addUser(user);

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/users/{username}")
	public User updateUser(@RequestBody User user, @PathVariable String username) throws UserServiceException {
		return userService.updateUser(username, user);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{Email}")
	public void deleteUser(@PathVariable int id) throws UserServiceException {
		userService.deleteUser(id);

	}
}
