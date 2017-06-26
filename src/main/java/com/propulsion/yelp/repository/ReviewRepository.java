package com.propulsion.yelp.repository;

import com.propulsion.yelp.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    
    Review findById( Long id );
    
    Review findByRating( Integer rating );
    
    void deleteById( Long id );
    
    Review save( Review review );
    
    @Modifying
    @Query("update Review u set u.text = ?1, u.rating = ?2 where u.id = ?3")
    void updateReviewById( String text, Integer rating, Long reviewId );
}
