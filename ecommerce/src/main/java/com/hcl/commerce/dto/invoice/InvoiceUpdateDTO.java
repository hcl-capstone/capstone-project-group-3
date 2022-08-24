package com.hcl.commerce.dto.invoice;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class InvoiceUpdateDTO {
	
	private Long invoiceId;
	
	private BigDecimal totalPrice;
	
	//private Address address;
	
	
}
