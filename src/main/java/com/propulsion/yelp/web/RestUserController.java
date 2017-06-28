package com.propulsion.yelp.web;

import com.fasterxml.jackson.annotation.JsonView;
import com.propulsion.yelp.domain.JsonViews;
import com.propulsion.yelp.domain.User;
import com.propulsion.yelp.service.DefaultUserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;

import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.fromMethodCall;
import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on;

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
    
    @GetMapping("/{id}")
    @JsonView(JsonViews.Detail.class)
    public User retrieveUser( @PathVariable Long id ) {
        return this.userService.findById( id );
    }
    
    //update User anonymous
    @PutMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void updateUser( @RequestBody Map<String, String> json, @PathVariable Long id ) {
        this.userService.updateUserById( json.get( "first_name" ), json.get( "last_name" ), id );
    }
    
    @PostMapping("/sign_up")
    public HttpEntity<Void> createUser( @RequestBody User postedUser ) {
        User savedUser = this.userService.save( postedUser );
        
        UriComponents uriComponents = fromMethodCall( on( getClass() ).retrieveUser( savedUser.getId() ) ).build();
        
        return ResponseEntity.created( uriComponents.encode().toUri() ).build();
    }
}
