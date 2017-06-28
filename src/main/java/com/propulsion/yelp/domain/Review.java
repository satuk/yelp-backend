package com.propulsion.yelp.domain;

import com.fasterxml.jackson.annotation.JsonView;
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
    @JsonView(JsonViews.Summary.class)
    private Long id;
    
    @JsonView(JsonViews.Summary.class)
    private String text;
    
    @JsonView(JsonViews.Summary.class)
    private Integer rating;
    
    @Column(name = "date_created", updatable = false, nullable = false)
    @JsonView(JsonViews.Summary.class)
    private LocalDateTime dateCreated = LocalDateTime.now();
    
    @ManyToOne
    @JsonView(JsonViews.Detail.class)
    private User user;
    
    @ManyToOne
//    @JsonView(JsonViews.Detail.class)
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
    
    @PrePersist
    protected void prePersist() {
        this.dateCreated = LocalDateTime.now();
    }
    
}
