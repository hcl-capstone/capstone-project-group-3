package com.hcl.commerce.dto.product;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductAddDTO {

	private String productName;

	private int stockCount;

	private BigDecimal unitPrice;
	
	private String image_url;

	private Long category;
}
