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
@Table(name = "address")
@Setter
@Getter
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long addressId;

	@Column(name = "street")
	private String street;

	@Column(name = "secondary")
	private String secondary;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "country")
	private String country;

	@Column(name = "zip")
	private String zip;
	
	public String addressOut() {
		String out = street + "\n" + city + "\n" + state + "\n" + zip;
		return out;
	}

	
}
