package com.propulsion.yelp.service;

import com.propulsion.yelp.domain.User;
import com.propulsion.yelp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class DefaultUserSevice implements UserService {
    
    //field:
    private final UserRepository userRepository;
    
    @Autowired
    //constructor:
    public DefaultUserSevice( UserRepository userRepository ) {
        this.userRepository = userRepository;
    }
    
    //METHODS:
    @Override
    public void deleteById( Long id ) {
        this.userRepository.deleteById( id );
    }
    
    @Override
    public User save( User user ) {
        return this.userRepository.save( user );
    }
    
    @Override
    public User findByFirstName( String firstName ) {
        return this.userRepository.findByFirstName( firstName );
    }
    
    @Override
    public void updateUserById( String firstName, String lastName, Long Id ) {
        this.userRepository.updateUserById( firstName, lastName, Id );
    }
}
