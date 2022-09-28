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

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "https://fruitilicious-frontend.azurewebsites.net")
@Slf4j
@RestController
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("user/registration")
	public Users registerUser(@RequestBody UserInputDTO dto) {
		log.info("User registered");
		return userService.registerUser(dto);
	}

	@GetMapping("user/get/{userId}") //read
	public Users getUser(@PathVariable Long userId) {
		log.info("User got got");
		return userService.getUser(userId);
	}

	@GetMapping("users/get/{userEmail}")
	public Users getUser(@PathVariable String userEmail) {
		log.info("User got email");
		return userService.getUserByEmail(userEmail);
	}

	@GetMapping("users/getIdToken/{IdToken}")
	public Users getUserByIdToken(@PathVariable String IdToken) {
		log.info("User Id Token got got");
		return userService.getUserByIdToken(IdToken);
	}

	@PostMapping("user/update/{userId}")
	public Users updateUser(@PathVariable Long userId, @RequestBody UserInputDTO dto) {
		log.info("User updated");
		return userService.updateUser(userId, dto);
	}

	@DeleteMapping("user/delete/{userId}") //delete
	public Users deleteUser(@PathVariable Long userId) {
		log.info("User deleted");
		return userService.deleteUser(userId);
	}

	@GetMapping("user/all")
	public List<Users> getAllUsers() {
		log.info("Got all users");
		return userService.getAllUser();
	}

	@PostMapping("user/login")
	public Users loginUser(@RequestBody UserLoginDTO dto) {
		log.info("User login");
		return userService.getUser(dto.getUsername(), dto.getPassword());
	}

	@GetMapping("user/get/name/{name}")
	public List<Users> getUserByName(@PathVariable String name){
		log.info("User got by name :)");
		return userService.getUserByName(name);
	}

}
