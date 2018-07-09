package com.login.loginpage.services;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.login.loginpage.controller.model.User;
import com.login.loginpage.exception.UserServiceException;
import com.login.loginpage.repository.UserRepository;
@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	public List<User> getAllUsers() throws UserServiceException {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		if (users != null && users.size() > 0) {
			return users;
			
			
		}
		else {
			throw new UserServiceException("There are no users");
		}

	}

	public User getUser(int id) throws UserServiceException {

		User users = userRepository.findById(id);

		if (users != null) {
			return users;

		} else {

			throw new UserServiceException("There are no users with id " + id);
		}

	}

	public User addUser(User user) throws UserServiceException {
		System.out.println("xyz"+user.toString());
		return userRepository.save(user);


	}

	public User updateUser(String username, User user) throws UserServiceException {

		return userRepository.save(user);
	}

	public void deleteUser(int id) throws UserServiceException {

		userRepository.deleteById(id);


	}

}
