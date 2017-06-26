package com.propulsion.yelp.service;

import com.propulsion.yelp.domain.Review;

public interface ReviewService {
	
	void deleteReview(Long id);
	
	Review saveReview(Review review);
	
	void updateReview(String text, Integer rating, Long id);

}
