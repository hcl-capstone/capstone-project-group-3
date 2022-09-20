package com.hcl.commerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.commerce.dto.user.UserInputDTO;
import com.hcl.commerce.dto.user.UserLoginDTO;
import com.hcl.commerce.entity.Users;
import com.hcl.commerce.service.user.UserService;

import lombok.extern.slf4j.Slf4j;

//@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
@RestController
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("user/registration")
	public Users registerUser(@RequestBody UserInputDTO dto) {
		log.info("User was registered");
		return userService.registerUser(dto);
	}

	@GetMapping("user/get/{userId}") //read
	public Users getUser(@PathVariable Long userId) {
		log.info("User got got");
		return userService.getUser(userId);
	}
	
	@GetMapping("users/get/{userEmail}")
	public Users getUser(@PathVariable String userEmail) {
		return userService.getUserByEmail(userEmail);
	}
	
	@PostMapping("user/update/{userId}")
	public Users updateUser(@PathVariable Long userId, @RequestBody UserInputDTO dto) {
		log.info("User info was updated");
		return userService.updateUser(userId, dto);
	}
			
	@DeleteMapping("user/delete/{userId}") //delete
	public Users deleteUser(@PathVariable Long userId) {
		log.info("User got deleted");
		return userService.deleteUser(userId);
	}

	@GetMapping("user/all")
	public List<Users> getAllUsers() {
		log.info("All users retrieved");
		return userService.getAllUser();
	}

	@PostMapping("user/login")
	public Users loginUser(@RequestBody UserLoginDTO dto) {
		log.info("Okta :)");
		return userService.getUser(dto.getUsername(), dto.getPassword());
	}
	
}
