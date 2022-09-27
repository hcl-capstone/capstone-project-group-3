package com.hcl.commerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "promos")
@Setter
@Getter
public class Promo {
	
	@Id
	@Column(name = "promo_code")
	private String promoCode;
	
	
	@Column(name = "discount")
	private double discount; 

}
