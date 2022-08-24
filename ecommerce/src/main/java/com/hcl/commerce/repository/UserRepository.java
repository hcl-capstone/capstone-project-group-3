package com.hcl.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.commerce.entity.User;

@org.springframework.stereotype.Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsernameAndPassword(String username, String password);

}
