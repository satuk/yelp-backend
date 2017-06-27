package com.propulsion.yelp.service;

import com.propulsion.yelp.domain.Restaurant;

import java.util.List;


public interface RestaurantService {
    
    List<Restaurant> findAll();
    
    List<Restaurant> findByName( String name );
    
    Restaurant findById( Long id );
    
}
