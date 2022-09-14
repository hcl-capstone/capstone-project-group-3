package com.hcl.commerce.service.invoice;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.hcl.commerce.Email;
import com.hcl.commerce.dto.invoice.InvoiceReceiptDTO;
import com.hcl.commerce.entity.Invoice;
import com.hcl.commerce.entity.Users;
import com.hcl.commerce.repository.InvoiceRepository;
import com.hcl.commerce.service.address.AddressService;
import com.hcl.commerce.service.product.ProductService;
import com.hcl.commerce.service.shoppingcart.ShoppingCartService;
import com.hcl.commerce.service.user.UserService;

@Service
public class InvoiceService {

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
	private JavaMailSender javaMailSender;

	
	public Invoice addInvoice(Long user_id) {
		Invoice invoice = new Invoice();
		invoice.setOrderStatus("Not Checked Out");
		Users user = userService.getUser(user_id);
		if(user != null) {
			user.addInvoice(invoice);
			return repo.save(invoice);
		}
		return null;
	}

	
	public Invoice getInvoice(Long id) {
		Optional<Invoice> invoice = repo.findById(id);
		if (invoice.isPresent()) {
			return invoice.get();
		}
		return null;
	}

	
	public Invoice updateInvoice(Long id) {
		Invoice invoice = getInvoice(id);
		invoice.updateTotalPrice();
		return repo.save(invoice);
	}

	
	public Invoice deleteInvoice(Long id) {
		Invoice invoice = getInvoice(id);
		repo.delete(invoice);
		return invoice;
	}

	
	public List<Invoice> getAllInvoice() {
		return repo.findAll();
	}

	
	public InvoiceReceiptDTO checkoutInvoice(Long id) {
		Invoice invoice = getInvoice(id);
		if (invoice != null && invoice.getAddress() != null) {
			invoice.setDateOrdered(LocalDate.now());
			invoice.setOrderStatus("Checked Out");
			invoice.updateTotalPrice();
			repo.save(invoice);
			InvoiceReceiptDTO receipt = new InvoiceReceiptDTO();
			BeanUtils.copyProperties(invoice, receipt);
			
			Users user = getUserFromInvoice(id);
			
			Email.sendCheckoutMail(javaMailSender, user.getEmail(), user.getFirstName(),receipt);
			
			return receipt;
		}
		return null;
	}
	
	private Users getUserFromInvoice(Long invoice_id) {
		List<Users> ulist = userService.getAllUser();
		for(Users user : ulist) {
			List<Invoice> ilist = user.getInvoices();
			for(Invoice invoice : ilist) {
				if(invoice.getInvoiceId().equals(invoice_id)) {
					return user;
				}
			}
		}
		return null;
	}

}
