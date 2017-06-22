package com.propulsion.yelp.service;

import java.util.List;

import com.propulsion.yelp.domain.Restaurant;


public interface RestaurantService {

	List<Restaurant> findAll();
	
	List<Restaurant> findByName(String name);
	
}
