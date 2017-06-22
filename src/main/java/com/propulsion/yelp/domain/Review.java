package com.propulsion.yelp.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "reviews")
@Data
@EqualsAndHashCode(exclude = "id")
public class Review {
	@Id
	private Long id;
	private String text;
	private Integer rating;
	private LocalDateTime dateCreated;
	@ManyToOne
	private User user;
	
	public Review () {
		
	}
}
