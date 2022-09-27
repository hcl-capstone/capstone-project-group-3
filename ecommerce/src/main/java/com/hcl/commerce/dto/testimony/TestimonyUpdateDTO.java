package com.hcl.commerce.dto.testimony;

import lombok.Data;

@Data
public class TestimonyUpdateDTO {
	private Long testimonyId;
	private String user;
	private String testimony;
	private int rating;
	private boolean status;
}
