package com.hcl.commerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "rating")
@Setter
@Getter
public class Rating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ratingId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "testimony")
	private String testimony;
	
	@Column(name = "rating")
	private int rating;
	
	
}
