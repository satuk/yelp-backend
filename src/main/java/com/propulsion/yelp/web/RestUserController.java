package com.propulsion.yelp.web;

import com.fasterxml.jackson.annotation.JsonView;
import com.propulsion.yelp.domain.JsonViews;
import com.propulsion.yelp.domain.User;
import com.propulsion.yelp.service.DefaultUserSevice;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.http.HttpStatus.NO_CONTENT;

import org.springframework.web.bind.annotation.*;

import com.propulsion.yelp.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class RestUserController {
    
    private final DefaultUserSevice userService;
    
    @Autowired
    public RestUserController( DefaultUserSevice userService ) {
        this.userService = userService;
    }
    
    @GetMapping
    @JsonView(JsonViews.Summary.class)
    public List<User> retrieveAllUsers() {
        return this.userService.findAll();
    }
    
    //update User anonymous
    @PutMapping("/user/{id}")
    @ResponseStatus(NO_CONTENT)
    public void updateuser( @RequestBody String firstName, String lastName, Long userId, @PathVariable Long id ) {
        userService.updateUserById( firstName, lastName, userId );
    }
}
