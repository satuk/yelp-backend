package com.propulsion.yelp.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode(exclude = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(JsonViews.Summary.class)
    private Long id;
    @JsonView({ JsonViews.Summary.class, JsonViews.Detail.class })
    private String firstName;
    @JsonView({ JsonViews.Summary.class, JsonViews.Detail.class })
    private String lastName;
    @Column(unique = true)
    @JsonView({ JsonViews.Summary.class, JsonViews.Detail.class })
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
