package com.hcl.commerce.service.shoppingcart;

import org.springframework.stereotype.Service;

import com.hcl.commerce.dto.shoppingcart.CartCreateDTO;
import com.hcl.commerce.dto.shoppingcart.CartUpdateDTO;
import com.hcl.commerce.entity.ShoppingCart;

@Service
public interface ShoppingCartService {

	public ShoppingCart createCart(CartCreateDTO dto);
	
	public ShoppingCart deleteCart(Long id);
	
	public ShoppingCart readCart(Long id);
	
	public ShoppingCart updateCart(CartUpdateDTO dto);
	
	public ShoppingCart saveCart(ShoppingCart cart);
}
