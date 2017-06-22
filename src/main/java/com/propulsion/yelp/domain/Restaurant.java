package com.propulsion.yelp.domain;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Table(name = "restaurants")
@Data
@EqualsAndHashCode(exclude = "id")
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String address;
	private String email;
	private String phone;
	private String logo;
	private String url;
	@OneToMany
	private List<Review> reviews = new ArrayList<>();
	
	public Restaurant() {
	}
	
	public Restaurant(Long id, String name, String address, String email, String phone, String logo, String url,
			List<Review> reviews) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.logo = logo;
		this.url = url;
		this.reviews = reviews;
	}
	
	public void addReview(Review review) {
		getReviews().add(review);
	}
	

	public Restaurant(String name, String address, String email, String phone, String logo, String url,
			List<Review> reviews) {
		this(null,name,address,email,phone,logo,url,reviews);
	}
	
}
