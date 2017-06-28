package com.propulsion.yelp.domain;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode(exclude = "id")
@ToString(exclude = "password")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(JsonViews.Summary.class)
    private Long id;
    
    @JsonView(JsonViews.Summary.class)
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;
    
    @Column(name = "last_name", nullable = false, length = 50)
    @JsonView(JsonViews.Summary.class)
    private String lastName;
    
    @Column(unique = true)
    @JsonView(JsonViews.Summary.class)
    private String email;
    
    private String password;
    
    
    public User() {
        /* default constructor: required by JPA */
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
