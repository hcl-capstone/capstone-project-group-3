package com.hcl.commerce.dto.rating;

import lombok.Data;

@Data
public class RatingUpdateDTO {

	private Long productId;
	private Long ratingId;
	private String name;
	private String testimony;
	private int rating;
}
