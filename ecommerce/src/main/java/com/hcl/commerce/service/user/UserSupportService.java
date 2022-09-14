package com.hcl.commerce.service.user;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.commerce.entity.Address;
import com.hcl.commerce.entity.Invoice;
import com.hcl.commerce.entity.Role;
import com.hcl.commerce.entity.Users;
import com.hcl.commerce.repository.UserRepository;
import com.hcl.commerce.service.address.AddressService;
import com.hcl.commerce.service.invoice.InvoiceService;
import com.hcl.commerce.service.role.RoleService;

@Service
public class UserSupportService{

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleService roleService;
	
	@Autowired
	AddressService addressService;
	
	@Autowired
	InvoiceService invoiceService;
	
	@Autowired
	UserServiceImplementation userService;


	public Set<Address> getAddress(Long user_id) {
		Users user = userService.getUser(user_id);
		if (user != null) {
			return user.getAddresses();
		}
		return null;
	}

	public List<Invoice> getInvoices(Long user_id) {
		Users user = userService.getUser(user_id);
		if (user != null) {
			return user.getInvoices();
		}
		return null;
	}
	
	public Set<Role> getRoles(Long user_id) {
		Users user = userService.getUser(user_id);
		if (user != null) {
			return user.getRoles();
		}
		return null;
	}

	public Users addRole(Long user_id, Long role_id) {
		Users user = userService.getUser(user_id);
		if (user != null) {
			user.addRole(roleService.getRole(role_id));
			return userRepository.save(user);
		}
		return null;
	}

	public Users addAddress(Long user_id, Long address_id) {
		Users user = userService.getUser(user_id);
		if (user != null) {
			user.addAddress(addressService.getAddress(address_id));
			return userRepository.save(user);
		}
		return null;
	}

	public Users addInvoice(Long user_id) {
		Users user = userService.getUser(user_id);
		if (user != null) {
			invoiceService.addInvoice(user_id);
			return user;
		}
		return null;
	}

}
