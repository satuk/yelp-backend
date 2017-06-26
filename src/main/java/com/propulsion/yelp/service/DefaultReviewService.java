package com.propulsion.yelp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.propulsion.yelp.domain.Review;
import com.propulsion.yelp.repository.ReviewRepository;

public class DefaultReviewService implements ReviewService {

	private final ReviewRepository repository;
	
	@Autowired
	public DefaultReviewService (ReviewRepository repository) {
        this.repository = repository;
    }

	@Override
	public void deleteReview(Long id) {
		this.repository.deleteById(id);

	}

	@Override
	public Review saveReview(Review review) {
		return this.repository.save(review);
	}

	@Override
	public void updateReview(String text, Integer rating, Long id) {
		this.repository.updateReviewById(text, rating, id);

	}

}
