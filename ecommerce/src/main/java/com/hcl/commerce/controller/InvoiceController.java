package com.hcl.commerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.commerce.dto.invoice.InvoiceReceiptDTO;
import com.hcl.commerce.entity.Invoice;
import com.hcl.commerce.service.invoice.InvoiceService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class InvoiceController {

	@Autowired
	InvoiceService invoiceService;
	
	@PostMapping("invoice/create/{user_id}")
	public Invoice addInvoice(@PathVariable Long user_id) {
		return invoiceService.addInvoice(user_id);
	}
	
	@GetMapping("invoice/get/{id}")
	public Invoice getInvoice(@PathVariable Long id) {
		return invoiceService.getInvoice(id);
	}
	
	@PostMapping("invoice/update/{id}")
	public Invoice updateInvoice(@PathVariable Long id) {
		return invoiceService.updateInvoice(id);
	}
	
	@DeleteMapping("invoice/delete/{id}")
	public Invoice deleteInvoice(@PathVariable Long id) {
		return invoiceService.deleteInvoice(id);
	}
	
	@GetMapping("invoice/all")
	public List<Invoice> allInvoice(){
		return invoiceService.getAllInvoice();
	}
	
	@PostMapping("invoice/checkout/{id}")
	public InvoiceReceiptDTO checkoutInvoice(@PathVariable Long id) {
		return invoiceService.checkoutInvoice(id);
	}
	
	
}
