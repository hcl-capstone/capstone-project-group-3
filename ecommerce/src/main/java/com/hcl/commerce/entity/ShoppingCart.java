package com.hcl.commerce.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private Long cartId;

	@ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
	
	@Column(name = "product_quantity")
	private int productQuantity;
	
	@Column(name = "cart_price")
	private BigDecimal cartPrice;
	
	public BigDecimal getProductCost() {
		//System.out.println(product.getProductName());
		return product.getUnitPrice();
	}
	
	public BigDecimal updateCartPrice() {
		BigDecimal result = this.getProductCost().multiply(BigDecimal.valueOf(productQuantity));
		this.cartPrice = result;
		return result;
	}
	

}
