package com.hcl.commerce.dto.product;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductAddDTO {

	private String productName;

	private int stockCount;

	private BigDecimal unitPrice;
	
	private String image_url;

	private Long category;
}
