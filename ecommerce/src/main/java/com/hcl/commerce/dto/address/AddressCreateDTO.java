package com.hcl.commerce.dto.address;

import lombok.Data;

@Data
public class AddressCreateDTO {

	private String street;

	private String secondary;

	private String city;

	private String state;

	private String country;

	private String zip;

	
}
