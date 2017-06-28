package com.propulsion.yelp.web;

import com.propulsion.yelp.domain.Token;
import com.propulsion.yelp.domain.User;
import com.propulsion.yelp.service.DefaultUserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by satuk on 28.06.17.
 */

//@RestController
//@RequestMapping("/api/users")
public class LoginController {
    
//    String token;
//
//    @Autowired
//    DefaultUserSevice userSevice;
//
//    @Autowired
//    public void getToken( @Value("${security.user.password}") String token ) {
//        this.token = token;
//    }
//
//    @RequestMapping(value = "/sign_in", method = POST, produces = "application/json")
//    @ResponseBody
//    public ResponseEntity<Token> retrieveToke( @RequestBody User user ) {
//
//        User userCheck = userSevice.findByEmail( user.getEmail() );
//
//        Token token = new Token();
//
//        if ( userCheck != null && userCheck.getPassword().equals( user.getPassword() ) ) {
//            token.setToken( this.token );
//        }
//
//        return ResponseEntity.accepted().body( token );
//    }
    
}
