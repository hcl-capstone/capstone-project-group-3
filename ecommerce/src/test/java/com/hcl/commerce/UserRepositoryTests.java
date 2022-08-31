package com.hcl.commerce;

import java.util.List;
import java.util.Optional;

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
	
	@Test
	void getUserListTest() {
		Users user = new Users();
		user.setFirstName("First");
		user.setLastName("Last");
		user.setEmail("email@email.com");
		user.setUsername("username");
		user.setPassword("password");
		
		userRepo.save(user);
		
		List<Users> users = userRepo.findAll();
		Assertions.assertThat(users.size()).isGreaterThan(0);
	}
	
	@Test
	void getUserTest() {
		Users user = new Users();
		user.setFirstName("First");
		user.setLastName("Last");
		user.setEmail("email@email.com");
		user.setUsername("username");
		user.setPassword("password");
		userRepo.save(user);
		
		List<Users> users = userRepo.findAll();
		
		Users user1 = userRepo.findById(1L).get();
		Assertions.assertThat(user1.getUserId()).isEqualTo(1L);
		
		//List<Users> users = userRepo.findAll();
		//Assertions.assertThat(users.size()).isGreaterThan(0);
		
	}
	
	
}
