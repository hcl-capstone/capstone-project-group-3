package com.hcl.commerce.dto.invoice;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.hcl.commerce.entity.Address;

import lombok.Data;

@Data
public class InvoiceReceiptDTO {
	
	private Long invoiceId;
	
	private BigDecimal totalPrice;
	
	private LocalDate dateOrdered;
	
	private String orderStatus;
	
	private Address address;
}
