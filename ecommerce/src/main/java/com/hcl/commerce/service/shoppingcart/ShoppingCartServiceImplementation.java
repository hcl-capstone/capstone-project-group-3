package com.hcl.commerce.service.shoppingcart;

import java.util.Optional;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.commerce.MessageController;
import com.hcl.commerce.dto.shoppingcart.CartCreateDTO;
import com.hcl.commerce.dto.shoppingcart.CartUpdateDTO;
import com.hcl.commerce.entity.Product;
import com.hcl.commerce.entity.ShoppingCart;
import com.hcl.commerce.repository.ShoppingCartRepository;
import com.hcl.commerce.service.product.ProductService;

@Service
public class ShoppingCartServiceImplementation implements ShoppingCartService {

	@Autowired
	ShoppingCartRepository repo;

	@Autowired
	ProductService productService;

	@Autowired
    private RabbitTemplate template;
	
	@Override
	public ShoppingCart createCart(CartCreateDTO dto) {
		ShoppingCart cart = new ShoppingCart();
		BeanUtils.copyProperties(dto, cart);
		cart.setProduct(productService.getProduct(dto.getProductId()));
        Product product = productService.getProduct(dto.getProductId());
        int count=product.getStockCount() - cart.getProductQuantity();

        if(count <= 10){

            MessageController mc=new MessageController(template);
            mc.inventoryStatus(cart.getProduct(),count);
        }
		cart.updateCartPrice();
		return repo.save(cart);
	}

	@Override
	public ShoppingCart readCart(Long id) {
		Optional<ShoppingCart> cart = repo.findById(id);
		if (cart.isPresent()) {
			return cart.get();
		}
		return null;
	}

	@Override
	public ShoppingCart deleteCart(Long id) {
		ShoppingCart cart = readCart(id);
		if (cart != null) {
			repo.delete(cart);
			return cart;
		}
		return null;
	}

	@Override
	public ShoppingCart updateCart(CartUpdateDTO dto) {
		ShoppingCart cart = readCart(dto.getCartId());
		if (cart != null) {
			BeanUtils.copyProperties(dto, cart);
			cart.updateCartPrice();
			return repo.save(cart);
		}
		return null;
	}

	@Override
	public ShoppingCart saveCart(ShoppingCart cart) {
		return repo.save(cart);
	}
	

}
