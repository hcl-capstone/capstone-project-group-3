package com.hcl.commerce.service.invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.commerce.dto.address.AddressCreateDTO;
import com.hcl.commerce.dto.shoppingcart.CartCreateDTO;
import com.hcl.commerce.dto.shoppingcart.CartUpdateDTO;
import com.hcl.commerce.entity.Address;
import com.hcl.commerce.entity.Invoice;
import com.hcl.commerce.entity.ShoppingCart;
import com.hcl.commerce.repository.InvoiceRepository;
import com.hcl.commerce.service.address.AddressService;
import com.hcl.commerce.service.product.ProductService;
import com.hcl.commerce.service.shoppingcart.ShoppingCartService;
import com.hcl.commerce.service.user.UserService;

@Service
public class InvoiceSupportService {

	@Autowired
	InvoiceRepository repo;

	@Autowired
	UserService userService;

	@Autowired
	ProductService productService;

	@Autowired
	ShoppingCartService cartService;
	
	@Autowired
	AddressService addressService;
	
	@Autowired
	InvoiceService invoiceService;
	
	public Invoice addInvoiceCart(Long invoice_id, CartCreateDTO dto) {
		Invoice invoice = invoiceService.getInvoice(invoice_id);
		ShoppingCart cart = cartService.createCart(dto);
		if (invoice != null && cart != null) {
			invoice.addCart(cart);
			repo.save(invoice);
			
			return invoiceService.updateInvoice(invoice_id);
			
		}
		return null;

	}

	
	public Invoice deleteInvoiceCart(Long invoice_id, Long cart_id) {
		Invoice invoice = invoiceService.getInvoice(invoice_id);
		ShoppingCart cart = cartService.deleteCart(cart_id);
		if (invoice != null && cart != null) {
			invoice.getCarts().remove(cart);
			return repo.save(invoice);
		}
		return null;
	}

	
	public ShoppingCart updateInvoiceCart(CartUpdateDTO dto) {
		ShoppingCart cart = cartService.updateCart(dto);
		return cart;
	}

	
	public Invoice addAddressToInvoice(Long invoice_id, Long address_id) {
		Invoice invoice = invoiceService.getInvoice(invoice_id);
		Address address = addressService.getAddress(address_id);
		if (invoice != null && address != null) {
			invoice.setAddress(address);
			return repo.save(invoice);
		}
		return null;
	}

	
	public Invoice addAddressToInvoice(Long invoice_id, AddressCreateDTO dto) {
		Invoice invoice = invoiceService.getInvoice(invoice_id);
		Address address = addressService.addAddress(dto);
		if (invoice != null && address != null) {
			invoice.setAddress(address);
			return repo.save(invoice);
		}
		return null;
	}


	public Invoice deleteProductFromCart(Long invoice_id, ShoppingCart shoppingCart) {
		Invoice invoice = invoiceService.getInvoice(invoice_id);
		ShoppingCart cart = shoppingCart;
		if (invoice != null && cart != null) {
			invoice.getCarts().remove(cart);
			return repo.save(invoice);
		}
		return null;
	}

}
