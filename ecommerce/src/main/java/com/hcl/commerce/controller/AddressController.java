package com.hcl.commerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.commerce.dto.address.AddressCreateDTO;
import com.hcl.commerce.entity.Address;
import com.hcl.commerce.service.address.AddressService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "https://fruitilicious-frontend.azurewebsites.net")
@RestController
public class AddressController {

	@Autowired
	AddressService serv;
	
	@PostMapping("address/create")
	public Address addAddress(@RequestBody AddressCreateDTO dto) {
		log.info("address was created");
		return serv.addAddress(dto);
		
	}
	
	@GetMapping("address/get/{address_id}")
	public Address getAddress(@PathVariable Long address_id) {
		log.info("Get address by addressId");
		return serv.getAddress(address_id);
	}
	
	@PostMapping("address/update/{address_id}")
	public Address updateAddress(@PathVariable Long address_id, @RequestBody AddressCreateDTO dto) {
		log.info("address was updated");
		return serv.updateAddress(address_id, dto);
	}
	
	@DeleteMapping("address/delete/{address_id}")
	public Address deleteAddress(@PathVariable Long address_id) {
		System.out.println(address_id);
		log.info("address was deleted");
		return serv.deleteAddress(address_id);
	}
	
	@GetMapping("address/all")
	public List<Address> allAddress(){
		log.info("all addresses were returned");
		return serv.getAllAddress();
	}
	
}
