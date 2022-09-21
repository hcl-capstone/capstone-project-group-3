package com.hcl.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.commerce.entity.Users;

@org.springframework.stereotype.Repository
public interface UserRepository extends JpaRepository<Users, Long>{

	Users findByUsernameAndPassword(String username, String password);

	Users findByEmail(String userEmail);

	Users findByIdToken(String idtoken); 

}
