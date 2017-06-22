package com.propulsion.yelp.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode(exclude = "id")
public class User {
	@Id
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	public User () {
		
	}
}
