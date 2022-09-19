package com.hcl.commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import java.util.List;

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
	
	@PostMapping("invoice/product/delete/{invoice_id}/{cart_id}")
	public Invoice removeProductFromInvoice(@PathVariable Long invoice_id, @PathVariable Long cart_id) {
		return invoiceSupportService.deleteInvoiceCart(invoice_id, cart_id);
	}
	
	@PostMapping("invoice/product/update")
	public ShoppingCart updateProductInInvoice(@RequestBody CartUpdateDTO dto) {
		return invoiceSupportService.updateInvoiceCart(dto);
	}
	
	@GetMapping("invoice/cart/get/{invoice_id}")
	public List<ShoppingCart> getCarts(@PathVariable Long invoice_id){
		return invoiceSupportService.getCarts(invoice_id);
	}
	
}
