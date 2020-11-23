package com.giridhar.firstapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.giridhar.firstapp.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	public User findByUserNameAndPassword(String userName, String password);

}
