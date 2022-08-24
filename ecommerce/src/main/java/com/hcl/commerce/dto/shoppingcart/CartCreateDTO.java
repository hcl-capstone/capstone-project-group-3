package com.hcl.commerce.dto.shoppingcart;

import lombok.Data;

@Data
public class CartCreateDTO {
	
	private int productQuantity;

    private Long productId;
}
