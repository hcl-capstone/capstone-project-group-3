package com.hcl.commerce.dto.rating;

import lombok.Data;

@Data
public class RatingCreateDTO {
	private Long productId;
	private String name;
	private String testimony;
	private int rating;
}
