package com.propulsion.yelp.security;

import com.propulsion.yelp.service.DefaultUserSevice;

/**
 * Created by satuk on 28.06.17.
 */
public class AccountCredentials {
    private String username;
    private String password;
    
    DefaultUserSevice userSevice;
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword( String password ) {
        this.password = password;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername( String username ) {
        this.username = username;
    }
}
