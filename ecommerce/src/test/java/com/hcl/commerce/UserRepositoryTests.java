package com.hcl.commerce;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.hcl.commerce.entity.Users;
import com.hcl.commerce.repository.UserRepository;

@DataJpaTest
public class UserRepositoryTests {

	@Autowired
	private UserRepository userRepo;
	
	@Test
	void saveUserTest() {
		Users user = new Users();
		user.setFirstName("First");
		user.setLastName("Last");
		user.setEmail("email@email.com");
		user.setUsername("username");
		user.setPassword("password");
		
		userRepo.save(user);
		
		Assertions.assertThat(user.getUserId()).isGreaterThan(0);
		
	}
}
