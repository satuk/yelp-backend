package com.propulsion.yelp.web;

import com.fasterxml.jackson.annotation.JsonView;
import com.propulsion.yelp.domain.JsonViews;
import com.propulsion.yelp.domain.Restaurant;
import com.propulsion.yelp.service.DefaultRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by satuk on 26.06.17.
 */

@RestController
@RequestMapping("/api/restaurants")
public class RestRestaurantController {
    
    private final DefaultRestaurantService restaurantService;
    
    
    @Autowired
    public RestRestaurantController( DefaultRestaurantService restaurantService ) {
        this.restaurantService = restaurantService;
    }
    
    @JsonView(JsonViews.Summary.class)
    @GetMapping
    public List<Restaurant> retrieveAllRestaurants() {
        return restaurantService.findAll();
    }
    
    @JsonView(JsonViews.Detail.class)
    @GetMapping("/{id}")
    public Restaurant retrieveRestaurants( @PathVariable Long id ) {
        return restaurantService.findById( id );
    }

    @JsonView(JsonViews.Summary.class)
    @RequestMapping(value = "/search", params = "query", method = GET)
    @ResponseBody
    public List<Restaurant> retrieveSearchedRestaurants( @RequestParam("query") String query ) {
        return restaurantService.findByNameIgnoreCaseContaining( query );
    }
}
