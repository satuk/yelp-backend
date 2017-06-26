package com.propulsion.yelp.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.propulsion.yelp.domain.Review;
import com.propulsion.yelp.domain.User;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@Transactional
@Sql("/test_data.sql")
public class ReviewRepositoryTests {
	
	@Autowired
	ReviewRepository repository;
	
	@Autowired
	RestaurantRepository repositoryrest;
	
	@Autowired
	UserRepository repositoryUser;
	
	@Test
	public void count() {
		assertThat(repository.count()).isEqualTo(1);
	}

	@Test
	public void deleteById() {
		repository.deleteById(2L);
		assertThat(repository.count()).isEqualTo(0);
		assertThat(repositoryrest.findById(3L).getReviews()).hasSize(0);
	}
	
	@Test
	public void saveReview() {
		User user = new User("firstName", "lastName", "email", "password");
		repositoryUser.save(user);
		assertThat(repositoryUser.count()).isEqualTo(2);
		Review review = new Review(89L, "text", 5, LocalDateTime.now(), user);
		repository.save(review);
		assertThat(repository.count()).isEqualTo(2);
	}
	
	@Test
	public void updateReview() {
		repository.updateReviewById("lalala", 7, 2L);
		assertThat(repository.findById(2L).getRating()).isEqualTo(7);
	}

}
