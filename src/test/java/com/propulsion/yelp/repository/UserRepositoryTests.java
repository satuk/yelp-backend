package com.propulsion.yelp.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

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
public class UserRepositoryTests {
	
	@Autowired
	UserRepository repository;
	
	User user = new User("asda", "asssda", "asdsasa", "asdas");

	@Test
	public void before() {
		assertThat(repository.count()).isEqualTo(1);
	}
	
	@Test
	public void saveUser() {
		repository.save(user);
		assertThat(repository.count()).isEqualTo(2);
	}
	
	
	@Test
	public void findById() {
		assertThat(repository.findById(1L).getFirstName()).isEqualTo("Petra");
	}
	
	@Test
	public void findByFirstName() {
		assertThat(repository.findByFirstName("Petra").getId()).isEqualTo(1);
	}
	
	@Test
	public void updateUser() {
		repository.updateUserById("Petra","Albu",1L);
		assertThat(repository.findById(1L).getLastName()).isEqualTo("Albu");
	}

}
