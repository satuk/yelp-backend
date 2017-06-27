package com.propulsion.yelp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.propulsion.yelp.domain.Review;
import com.propulsion.yelp.repository.ReviewRepository;

@Service
@Transactional
public class DefaultReviewService implements ReviewService {
    
    private final ReviewRepository repository;
    
    @Autowired
    public DefaultReviewService( ReviewRepository repository ) {
        this.repository = repository;
    }
    
    @Override
    public void deleteReview( Long id ) {
        this.repository.deleteById( id );
        
    }
    
    @Override
    public Review saveReview( Review review ) {
        return this.repository.save( review );
    }
    
    @Override
    public void updateReview( String text, Integer rating, Long id ) {
        this.repository.updateReviewById( text, rating, id );
        
    }
    
    @Override
    public List<Review> findAll() {
        return repository.findAll();
    }
    
    @Override
    public Review findById( Long id ) {
        return repository.findById( id );
    }
    
}
