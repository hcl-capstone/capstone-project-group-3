package com.hcl.commerce.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.commerce.entity.Address;
import com.hcl.commerce.entity.Invoice;
import com.hcl.commerce.entity.Role;
import com.hcl.commerce.entity.User;
import com.hcl.commerce.service.user.UserSupportService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserSupportController {
	@Autowired
	UserSupportService userService;
	
	@GetMapping("user/address/get/{user_id}")
	public Set<Address> getAddress(@PathVariable Long user_id){
		return userService.getAddress(user_id);
	}
	
	@GetMapping("user/invoice/get/{user_id}")
	public List<Invoice> getInvoice(@PathVariable Long user_id){
		return userService.getInvoices(user_id);
	}
	
	@GetMapping("user/role/get/{user_id}")
	public Set<Role> getRole(@PathVariable Long user_id){
		return userService.getRoles(user_id);
	}
	
	@PostMapping("user/role/add/{user_id}/{role_id}")
	public User addRole(@PathVariable Long user_id, @PathVariable Long role_id) {
		return userService.addRole(user_id, role_id);
	}
	
	@PostMapping("user/address/set/{user_id}/{address_id}")
	public User addAddress(@PathVariable Long user_id, @PathVariable Long address_id) {
		return userService.addAddress(user_id, address_id);
	}
	
	@PostMapping("user/invoice/add/{user_id}")
	public User addInvoice(@PathVariable Long user_id) {
		return userService.addInvoice(user_id);
	}
}
