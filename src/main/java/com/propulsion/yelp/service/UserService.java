package com.propulsion.yelp.service;

import com.propulsion.yelp.domain.User;

public interface UserService {

    void deleteById( Long id );

    User save( User user );

    User findByFirstName( String firstName );

    void updateUserById( String firstName, String lastName, Long Id );

}
