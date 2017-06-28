package com.propulsion.yelp.web;

import com.fasterxml.jackson.annotation.JsonView;
import com.propulsion.yelp.domain.JsonViews;
import com.propulsion.yelp.domain.Review;
import com.propulsion.yelp.service.DefaultReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by satuk on 28.06.17.
 */

@RestController
@RequestMapping("/api/reviews")
public class RestReviewController {
    
    private final DefaultReviewService reviewService;
    
    @Autowired
    public RestReviewController( DefaultReviewService reviewService ) {
        this.reviewService = reviewService;
    }
    
    // update
    // delete
    // save
    @JsonView(JsonViews.Summary.class)
    @GetMapping
    public List<Review> retrieveAllReviews() {
        return this.reviewService.findAll();
    }

    @JsonView(JsonViews.Detail.class)
    @GetMapping("/{id}")
    public Review retrieveReview( @PathVariable Long id ) {
        return this.reviewService.findById( id );
    }
    
}
