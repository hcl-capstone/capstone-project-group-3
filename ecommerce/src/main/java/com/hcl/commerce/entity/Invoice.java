package com.hcl.commerce.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "invoice")
@Getter
@Setter
public class Invoice {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "invoice_id")
	private Long invoiceId;

	@Column(name = "total_price")
	private BigDecimal totalPrice;

	@Column(name = "order_status")
	private String orderStatus;

	@Column(name = "checkout_date")
	private LocalDate dateOrdered;
	
	@OneToMany
	@JoinColumn(name="invoice_id")
	private List<ShoppingCart> carts = new ArrayList<>();
	
	@ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
	
	public void addCart(ShoppingCart cart) {
		this.carts.add(cart);
	}
	
	public void updateTotalPrice() {
		System.out.println("Updating Total Price (From Invoice entity)");
		BigDecimal newtotalPrice = BigDecimal.ZERO;
		for(ShoppingCart cart : carts) {
			BigDecimal productPrice = cart.getProductCost();
			int count = cart.getProductQuantity();
			productPrice = productPrice.multiply(BigDecimal.valueOf(count));
			//System.out.println("Adding Price: " + productPrice);
			newtotalPrice = newtotalPrice.add(productPrice);
			//System.out.println("New Total Price: " + newtotalPrice);
		}
		this.totalPrice = newtotalPrice;
	}
}
