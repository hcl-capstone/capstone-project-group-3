package com.hcl.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.commerce.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
