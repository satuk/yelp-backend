package com.propulsion.yelp.service;

import com.propulsion.yelp.domain.User;

import java.util.List;

public interface UserService {
    
    User save( User user );
    
    User findByFirstName( String firstName );
    
    User findById( Long id );
    
    List<User> findAll();
    
    void updateUserById( String firstName, String lastName, Long Id );
    
    User anonymousUserById( Long id );
    
    User findByEmail( String email );
    
}
