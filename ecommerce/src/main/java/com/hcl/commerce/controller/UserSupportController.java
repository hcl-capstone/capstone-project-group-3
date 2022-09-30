package com.hcl.commerce.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.commerce.dto.address.AddressCreateDTO;
import com.hcl.commerce.entity.Address;
import com.hcl.commerce.entity.Invoice;
import com.hcl.commerce.entity.Role;
import com.hcl.commerce.entity.Users;
import com.hcl.commerce.service.user.UserSupportService;

import lombok.extern.slf4j.Slf4j;


@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
@RestController
public class UserSupportController {
	@Autowired
	UserSupportService userService;

	@GetMapping("user/address/get/{user_id}")
	public Set<Address> getAddress(@PathVariable Long user_id){
		log.info("Getting address through userId");
		return userService.getAddress(user_id);
	}

	@GetMapping("user/invoice/get/{user_id}")
	public List<Invoice> getInvoice(@PathVariable Long user_id){
		log.info("Getting invoice through userId");
		return userService.getInvoices(user_id);
	}

	@GetMapping("user/role/get/{user_id}")
	public Set<Role> getRole(@PathVariable Long user_id){
		log.info("Getting user_role by userId");
		return userService.getRoles(user_id);
	}

	@PostMapping("user/role/add/{user_id}/{role_id}")
	public Users addRole(@PathVariable Long user_id, @PathVariable Long role_id) {
		log.info("Adding user_role by UserId");
		return userService.addRole(user_id, role_id);
	}

	@PostMapping("user/address/set/{user_id}/{address_id}")
	public Users addAddress(@PathVariable Long user_id, @PathVariable Long address_id) {
		log.info("Setting address to userId by addressId");
		return userService.addAddress(user_id, address_id);
	}

	@PostMapping("user/address/set/{user_id}")
	public Users addAddress(@PathVariable Long user_id, @RequestBody AddressCreateDTO address) {
		log.info("Setting address to userId by address object");
		return userService.addAddress(user_id, address);
	}

	@PostMapping("user/invoice/add/{user_id}")
	public Users addInvoice(@PathVariable Long user_id) {
		log.info("Add userId to invoice");
		return userService.addInvoice(user_id);
	}
}
