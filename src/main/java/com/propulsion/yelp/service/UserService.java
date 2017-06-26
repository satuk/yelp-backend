package com.propulsion.yelp.service;

import java.util.List;

import com.propulsion.yelp.domain.User;

public interface UserService {

	User save(User user);
	
	User findByFirstName(String firstName);
	
	User findById(Long id);
	
	List<User> findAll();
	
	void updateUserById(String firstName, String lastName, Long Id);

}
