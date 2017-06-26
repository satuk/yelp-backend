package com.propulsion.yelp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.propulsion.yelp.domain.User;
import com.propulsion.yelp.repository.UserRepository;

@Transactional
@Service
public class DefaultUserSevice implements UserService{

	//field:
	private final UserRepository userRepository;

	@Autowired
	//constructor:
	public DefaultUserSevice(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	//METHODS:
	@Override
	public User save(User user) {
		return this.userRepository.save(user);
	}

	@Override
	public User findByFirstName(String firstName) {
		return this.userRepository.findByFirstName(firstName);
	}

	@Override
	public void updateUserById(String firstName, String lastName, Long Id) {
		this.userRepository.updateUserById(firstName, lastName, Id);
	}

	@Override
	public List<User> findAll() {
		return this.userRepository.findAll();
	}

	@Override
	public User findById(Long id) {
		return this.userRepository.findById(id);
	}
}
