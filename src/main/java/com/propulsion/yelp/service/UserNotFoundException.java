package com.propulsion.yelp.service;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * Created by satuk on 28.06.17.
 */

@ResponseStatus(NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    public UserNotFoundException( String message ) {
        super( message );
    }
    
    public UserNotFoundException( String message, Throwable cause ) {
        super( message, cause );
    }
}
