package com.propulsion.yelp.service;

import static org.junit.Assert.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import com.propulsion.yelp.repository.RestaurantRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = NONE)
@Transactional
@Sql("/test_data.sql")
public class RestaurantServiceTests {
	
	@Autowired
	RestaurantService service;

	@Test
	public void findAll() {
		assertThat(service.findAll().size()).isEqualTo(1);
	}

	@Test
	public void findByName() {
		assertThat(service.findByName("Petra").size()).isEqualTo(1);
	}
}
