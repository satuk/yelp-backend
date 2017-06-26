package com.propulsion.yelp.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.propulsion.yelp.domain.Restaurant;
import com.propulsion.yelp.domain.Review;
import com.propulsion.yelp.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = NONE)
@Transactional
@Sql("/test_data.sql")
public class ReviewServiceTests {
	
	@Autowired
	ReviewService service;
	
	@Autowired
	UserService userService;
	
	@Autowired
	RestaurantService restaurantService;
	
	User user = new User("firstName", "lastName", "email", "password");
	List array = new ArrayList<>();


	@Test
	public void before() {
		assertThat(service.findAll().size()).isEqualTo(1);
	}
	
	@Test
	public void saveReview() {
		userService.save(user);
		Restaurant restaurant = restaurantService.findById(3L);
		Review review = new Review("text", 8, LocalDateTime.now(), user, restaurant);
		service.saveReview(review);
		assertThat(service.findAll().size()).isEqualTo(2);
		assertThat(restaurantService.findById(3L).getReviews().size()).isEqualTo(2);
	}
	
	@Test
	public void updateReview() {
		service.updateReview("lalala", 5, 2L);
		assertThat(service.findById(2L).getRating()).isEqualTo(5);
		assertThat(restaurantService.findById(3L).getReviews()
				.get(0).getRating()).isEqualTo(5);
	}
	
	@Test
	public void deleteReview() {
		service.deleteReview(2L);
		assertThat(service.findAll().size()).isEqualTo(0);
		assertThat(restaurantService.findById(3L).getReviews().size()).isEqualTo(0);
	}

}
