package com.propulsion.yelp.service;

import static org.junit.Assert.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.propulsion.yelp.domain.Review;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = NONE)
@Transactional
@Sql("/test_data.sql")
public class ReviewServiceTests {
	
	@Autowired
	ReviewService service;

	@Test
	public void before() {
		assertThat(service.findAll().size()).isEqualTo(1);
	}
	
	@Test
	public void saveReview() {
		User user = 
		Review review = new Review("review", 5, , user)
		assertThat(service.findAll().size()).isEqualTo(1);
	}

}
