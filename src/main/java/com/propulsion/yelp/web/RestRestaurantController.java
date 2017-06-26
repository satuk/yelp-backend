package com.propulsion.yelp.web;

import com.fasterxml.jackson.annotation.JsonView;
import com.propulsion.yelp.domain.JsonViews;
import com.propulsion.yelp.domain.Restaurant;
import com.propulsion.yelp.service.DefaultRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by satuk on 26.06.17.
 */

@RestController
@RequestMapping("/api")
public class RestRestaurantController {
    
    private final DefaultRestaurantService restaurantService;
    
    
    @Autowired
    public RestRestaurantController( DefaultRestaurantService restaurantService ) {
        this.restaurantService = restaurantService;
    }
    
    @JsonView(JsonViews.Summary.class)
    @GetMapping("/restaurants")
    public List<Restaurant> retrieveAllRestaurants() {
        
        List<Restaurant> restaurants = restaurantService.findAll();
        
        System.out.println( restaurants );
        System.out.println( restaurants.size() );
        return restaurants;
    }
}
