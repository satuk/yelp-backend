package com.propulsion.yelp.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.propulsion.yelp.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@Transactional
@Sql("/test_data.sql")
public class UserServiceTests {

	@Autowired
	UserService userService;
	
	@Test
	public void testSave() {
		User user2 = new User ("Nancy", "Anggraini", "example2@email.com", "password");
		assertThat(userService.findAll()).hasSize(1);
		
		userService.save(user2);
		assertThat(userService.findAll()).hasSize(2);
	}
	
	@Test
	public void testFindByFirstName() {
		User user2 = new User ("Nancy", "Anggraini", "example2@email.com", "password");
		userService.save(user2);
		assertThat(userService.findByFirstName("Nancy")).isEqualTo(user2);
		
		assertThat(userService.findByFirstName("Petra").getLastName()).isEqualTo("Pistalu");
	}
	
	@Test
	public void testFindById() {
		assertThat(userService.findById(1L).getFirstName()).isEqualTo("Petra");
	}
	
	@Test
	public void testUpdateUserById() {
		//TEST BY ADDING NEW USER:
		User user2 = new User ("Nancy", "Anggraini", "example2@email.com", "password");
		userService.save(user2);
		//getting the id:
		userService.updateUserById("Beyonce", "Anggraini", userService.findByFirstName("Nancy").getId());
		assertThat(userService.findByFirstName("Beyonce").getLastName()).isEqualTo("Anggraini");
		
//		//TEST BY USING test_data.sql:
		userService.updateUserById("Petra", "Albu", 1L);
		assertThat(userService.findById(1L).getLastName()).isEqualTo("Albu");
	}
}
