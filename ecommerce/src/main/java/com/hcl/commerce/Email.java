package com.hcl.commerce;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.hcl.commerce.dto.invoice.InvoiceReceiptDTO;

public class Email {
	
	public static void sendRegistrationMail(JavaMailSender javaMailSender, String email, String name) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(email);

		msg.setSubject("You've signed up for Capstone Commerce!");
		msg.setText("Welcome, "+name+".\n"
				+ " Thank you for signing up.");

		javaMailSender.send(msg);

	}
	
	public static void sendCheckoutMail(JavaMailSender javaMailSender, String email, String name, InvoiceReceiptDTO dto) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(email);

		msg.setSubject("Checkout Successful!");
		msg.setText("Hello, "+name+". Thank you for purchasing from Capstone E-Commerce.\n"
				+   "The order was processed on "+dto.getDateOrdered()+",\n"
				+   "and will be shipped to the following address:\n"
				+   dto.getAddress().addressOut() + "\n\n"
				+   "The total charge comes to $"+dto.getTotalPrice()
				);

		javaMailSender.send(msg);

	}
}
