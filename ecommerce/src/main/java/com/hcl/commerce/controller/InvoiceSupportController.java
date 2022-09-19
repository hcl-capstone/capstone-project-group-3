package com.hcl.commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.commerce.dto.address.AddressCreateDTO;
import com.hcl.commerce.dto.shoppingcart.CartCreateDTO;
import com.hcl.commerce.dto.shoppingcart.CartUpdateDTO;
import com.hcl.commerce.entity.Invoice;
import com.hcl.commerce.entity.ShoppingCart;
import com.hcl.commerce.service.invoice.InvoiceSupportService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class InvoiceSupportController {
	
	@Autowired
	InvoiceSupportService invoiceSupportService;
	
	
	@PostMapping("invoice/address/set/{invoice_id}/{address_id}")
	public Invoice addAddressToInvoice(@PathVariable Long invoice_id, @PathVariable Long address_id){
		return invoiceSupportService.addAddressToInvoice(invoice_id, address_id);
	}
	
	@PostMapping("invoice/address/set/{invoice_id}")
	public Invoice addAddressToInvoice(@PathVariable Long invoice_id, @RequestBody AddressCreateDTO dto){
		return invoiceSupportService.addAddressToInvoice(invoice_id, dto);
	}
	
	@PostMapping("invoice/product/add/{invoice_id}")
	public Invoice addProductToInvoice(@PathVariable Long invoice_id, @RequestBody CartCreateDTO dto) {
		return invoiceSupportService.addInvoiceCart(invoice_id, dto);
	}
	
	@GetMapping("invoice/product/delete/{invoice_id}/{cart_id}")
	public Invoice removeProductFromInvoice(@PathVariable Long invoice_id, @PathVariable Long cart_id) {
		return invoiceSupportService.deleteInvoiceCart(invoice_id, cart_id);
	}
	@GetMapping("user/invoice/product/delete/{invoice_id}/{cart}")
	public Invoice removeProductFromInvoice2(@PathVariable Long invoice_id, @PathVariable ShoppingCart shoppingCart) {
		return invoiceSupportService.deleteProductFromCart(invoice_id, shoppingCart);
	}
	@PostMapping("invoice/product/update")
	public ShoppingCart updateProductInInvoice(@RequestBody CartUpdateDTO dto) {
		return invoiceSupportService.updateInvoiceCart(dto);
	}
	
}
