package com.hcl.commerce.service.address;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.commerce.dto.address.AddressCreateDTO;
import com.hcl.commerce.entity.Address;
import com.hcl.commerce.repository.AddressRepository;

@Service
public class AddressServiceImplementation implements AddressService {

	@Autowired
	AddressRepository repo;

	@Override
	public Address addAddress(AddressCreateDTO dto) {
		Address address = new Address();
		BeanUtils.copyProperties(dto, address);
		return repo.save(address);
	}

	@Override
	public Address getAddress(Long address_id) {
		Optional<Address> address = repo.findById(address_id);
		if (address.isPresent()) {
			return address.get();
		}
		return null;
	}

	@Override
	public Address updateAddress(Long address_id, AddressCreateDTO dto) {
		Address address = getAddress(address_id);
		if (address != null) {
			BeanUtils.copyProperties(dto, address);
			return repo.save(address);
		}
		return null;
	}

	@Override
	public Address deleteAddress(Long address_id) {
		Address address = getAddress(address_id);
		if (address != null) {
			repo.delete(address);
			return address;
		}
		return null;
	}

	@Override
	public List<Address> getAllAddress() {
		return repo.findAll();
	}

}
