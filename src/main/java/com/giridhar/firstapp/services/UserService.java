package com.giridhar.firstapp.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.giridhar.firstapp.model.User;
import com.giridhar.firstapp.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	private final UserRepository userRepository;
	
	public UserService (UserRepository ur) {
		this.userRepository = ur;
	}
	
	public void saveUserToDB (User user) {
		userRepository.save(user);
	}
	
	public User findByUserNameAndPassword(String userName, String password) {
		return userRepository.findByUserNameAndPassword(userName, password);
	}

}
