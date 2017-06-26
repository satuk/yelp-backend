package com.propulsion.yelp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.propulsion.yelp.domain.Restaurant;
import com.propulsion.yelp.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{


	User save(User user);

	User findById(Long id);
	
	User findByEmail(String email);
	
	User findByFirstName(String firstName);
	
	@Modifying
	@Query("update User u set u.firstName = ?1, u.lastName = ?2 where u.id = ?3")
	void updateUserById(String firstName, String lastName, Long Id);
	
}
