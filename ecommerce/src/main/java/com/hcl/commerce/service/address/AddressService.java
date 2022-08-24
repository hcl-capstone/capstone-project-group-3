package com.hcl.commerce.service.address;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.commerce.dto.address.AddressCreateDTO;
import com.hcl.commerce.entity.Address;

@Service
public interface AddressService {

	Address addAddress(AddressCreateDTO dto);

	Address getAddress(Long address_id);

	Address updateAddress(Long address_id, AddressCreateDTO dto);

	Address deleteAddress(Long address_id);

	List<Address> getAllAddress();

}
