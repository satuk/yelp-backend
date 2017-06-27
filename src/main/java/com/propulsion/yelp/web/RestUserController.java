package com.propulsion.yelp.web;

import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.http.HttpStatus.NO_CONTENT;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.propulsion.yelp.service.UserService;

@RestController
@RequestMapping("/api")
public class RestUserController {
    
    private final UserService userService;
    
    @Autowired
    public RestUserController( UserService userService ) {
        this.userService = userService;
    }
    
    //update User anonymous
    @PutMapping("/user/{id}")
    @ResponseStatus(NO_CONTENT)
    public void updateuser( @RequestBody String firstName, String lastName,
                            Long userId, @PathVariable Long id ) {
        userService.updateUserById( firstName, lastName, userId );
    }
}
