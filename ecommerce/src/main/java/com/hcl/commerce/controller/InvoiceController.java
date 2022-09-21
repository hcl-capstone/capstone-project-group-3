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

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class InvoiceController {

	@Autowired
	InvoiceService invoiceService;
	
	@PostMapping("invoice/create/{user_id}")
	public Invoice addInvoice(@PathVariable Long user_id) {
		log.info("invoice was created");
		return invoiceService.addInvoice(user_id);
	}
	
	@GetMapping("invoice/get/{id}")
	public Invoice getInvoice(@PathVariable Long id) {
		log.info("invoice was retreived by invoiceId");
		return invoiceService.getInvoice(id);
	}
	
	@PostMapping("invoice/update/{id}")
	public Invoice updateInvoice(@PathVariable Long id) {
		log.info("invoice was updated");
		return invoiceService.updateInvoice(id);
	}
	
	@DeleteMapping("invoice/delete/{id}")
	public Invoice deleteInvoice(@PathVariable Long id) {
		log.info("invoice was deleted");
		return invoiceService.deleteInvoice(id);
	}
	
	@GetMapping("invoice/all")
	public List<Invoice> allInvoice(){
		log.info("All invoices were retrieved");
		return invoiceService.getAllInvoice();
	}
	
	@PostMapping("invoice/checkout/{id}")
	public InvoiceReceiptDTO checkoutInvoice(@PathVariable Long id) {
		log.info("User checked out invoice");
		return invoiceService.checkoutInvoice(id);
	}
	
	
}
