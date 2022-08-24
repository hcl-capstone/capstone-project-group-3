package com.hcl.commerce.dto.shoppingcart;

import lombok.Data;

@Data
public class CartUpdateDTO {
	private Long cartId;
	private int productQuantity;
}
