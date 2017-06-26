package com.propulsion.yelp.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode(exclude = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    
    public User() {
    }
    
    public User( Long id, String firstName, String lastName, String email, String password ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
    
    public User( String firstName, String lastName, String email, String password ) {
        this( null, firstName, lastName, email, password );
    }
    
    
}
