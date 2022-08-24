package com.hcl.commerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.commerce.dto.address.AddressCreateDTO;
import com.hcl.commerce.entity.Address;
import com.hcl.commerce.service.address.AddressService;

@RestController
public class AddressController {

	@Autowired
	AddressService serv;
	
	@PostMapping("address/create")
	public Address addAddress(@RequestBody AddressCreateDTO dto) {
		return serv.addAddress(dto);
	}
	
	@GetMapping("address/get/{address_id}")
	public Address getAddress(@PathVariable Long address_id) {
		return serv.getAddress(address_id);
	}
	
	@PostMapping("address/update/{address_id}")
	public Address updateAddress(@PathVariable Long address_id, @RequestBody AddressCreateDTO dto) {
		return serv.updateAddress(address_id, dto);
	}
	
	@DeleteMapping("address/delete/{address_id}")
	public Address deleteAddress(@PathVariable Long address_id) {
		System.out.println(address_id);
		return serv.deleteAddress(address_id);
	}
	
	@GetMapping("address/all")
	public List<Address> allAddress(){
		return serv.getAllAddress();
	}
	
}
