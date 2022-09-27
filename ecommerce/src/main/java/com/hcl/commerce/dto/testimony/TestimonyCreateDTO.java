package com.hcl.commerce.dto.testimony;

import lombok.Data;

@Data
public class TestimonyCreateDTO {
	private String user;
	private String testimony;
	private int rating;
}
