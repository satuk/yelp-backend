package com.propulsion.yelp.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
@Data
@EqualsAndHashCode(exclude = "id")
public class Review implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    private Integer rating;
    @Column(name = "date_created", updatable = false, nullable = false)
    private LocalDateTime dateCreated = LocalDateTime.now();
    @ManyToOne
    private User user;
    @ManyToOne
    private Restaurant restaurant;
    
    public Review() {
    }
    
    public Review( Long id, String text, Integer rating, LocalDateTime dateCreated, User user ) {
        this.id = id;
        this.text = text;
        this.rating = rating;
        this.dateCreated = dateCreated;
        this.user = user;
    }
    
    @PrePersist
    protected void prePersist() {
        this.dateCreated = LocalDateTime.now();
    }
    
    public Review( String text, Integer rating, LocalDateTime dateCreated, User user ) {
        this( null, text, rating, dateCreated, user );
    }
    
    public Review( String text, Integer rating, LocalDateTime dateCreated, User user, Restaurant restaurant ) {
        this.text = text;
        this.rating = rating;
        this.dateCreated = dateCreated;
        this.user = user;
        this.restaurant = restaurant;
    }
    
}
