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
@Table(name = "testimony")
@Setter
@Getter
public class Testimony {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long testimonyId;
	
	@Column(name = "user")
	private String user;
	
	@Column(name = "testimony")
	private String testimony;
	
	@Column(name = "rating")
	private int rating;
	
	@Column(name = "status")
	private boolean status;
	
	
}
