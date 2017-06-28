package com.propulsion.yelp.domain;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "restaurants")
@Data
@EqualsAndHashCode(exclude = "id")
public class Restaurant {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(JsonViews.Summary.class)
    private Long id;
    
    @JsonView(JsonViews.Summary.class)
    private String name;
    
    @JsonView(JsonViews.Summary.class)
    private String address;
    
    @JsonView(JsonViews.Summary.class)
    private String email;
    
    @JsonView(JsonViews.Summary.class)
    private String phone;
    
    @JsonView(JsonViews.Detail.class)
    private String logo;
    
    @JsonView(JsonViews.Summary.class)
    private String url;
    
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.REMOVE)
    @JsonView(JsonViews.Detail.class)
    private List<Review> reviews = new ArrayList<>();
    
    public Restaurant() {
    }
    
    public Restaurant( Long id, String name, String address, String email, String phone, String logo, String url, List<Review> reviews ) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.logo = logo;
        this.url = url;
        this.reviews = reviews;
    }
    
    public Restaurant( String name, String address, String email, String phone, String logo, String url, List<Review> reviews ) {
        this( null, name, address, email, phone, logo, url, reviews );
    }
    
    public void addReview( Review review ) {
        reviews.add( review );
    }
    
}
