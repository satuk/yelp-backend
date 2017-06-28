package com.propulsion.yelp.service;

import com.propulsion.yelp.domain.User;
import com.propulsion.yelp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    
    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }
    
    @Override
    public User findById( Long id ) {
        User user = this.userRepository.findById( id );
        
        if ( user == null ) {
            throw new UserNotFoundException( "Could not find User with ID [" + id + "]" );
        }
        return this.userRepository.findById( id );
    }
    
    @Override
    public User anonymousUserById( Long id ) {
        User user = this.userRepository.findById( id );
        user.setFirstName( "Anonymous" );
        user.setLastName( "Anonymous" );
        return this.userRepository.save( user );
    }
    
    @Override
    public User findByEmail( String email ) {
        return this.userRepository.findByEmail( email );
    }
}
