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

import com.hcl.commerce.dto.user.UserInputDTO;
import com.hcl.commerce.dto.user.UserLoginDTO;
import com.hcl.commerce.entity.Users;
import com.hcl.commerce.service.user.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("user/registration")
	public Users registerUser(@RequestBody UserInputDTO dto) {
		return userService.registerUser(dto);
	}

	@GetMapping("user/get/{userId}") //read
	public Users getUser(@PathVariable Long userId) {
		return userService.getUser(userId);
	}

	@GetMapping("users/get/{userEmail}")
	public Users getUser(@PathVariable String userEmail) {
		return userService.getUserByEmail(userEmail);
	}

	@GetMapping("users/getIdToken/{IdToken}")
	public Users getUserByIdToken(@PathVariable String IdToken) {
		return userService.getUserByIdToken(IdToken);
	}

	@PostMapping("user/update/{userId}")
	public Users updateUser(@PathVariable Long userId, @RequestBody UserInputDTO dto) {
		return userService.updateUser(userId, dto);
	}

	@DeleteMapping("user/delete/{userId}") //delete
	public Users deleteUser(@PathVariable Long userId) {
		return userService.deleteUser(userId);
	}

	@GetMapping("user/all")
	public List<Users> getAllUsers() {
		return userService.getAllUser();
	}

	@PostMapping("user/login")
	public Users loginUser(@RequestBody UserLoginDTO dto) {
		return userService.getUser(dto.getUsername(), dto.getPassword());
	}

	@GetMapping("user/get/name/{name}")
	public List<Users> getUserByName(@PathVariable String name){
		return userService.getUserByName(name);
	}

}
