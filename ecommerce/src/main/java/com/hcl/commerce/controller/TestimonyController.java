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

import com.hcl.commerce.dto.testimony.TestimonyCreateDTO;
import com.hcl.commerce.dto.testimony.TestimonyUpdateDTO;
import com.hcl.commerce.entity.Testimony;
import com.hcl.commerce.service.testimony.TestimonyService;

@CrossOrigin(origins = "https://fruitilicious-frontend.azurewebsites.net")
@RestController
public class TestimonyController {
	
	@Autowired
	TestimonyService testimonyService;
	
	
	//CRUD
	@PostMapping("testimony/create")
	public Testimony createTestimony(@RequestBody TestimonyCreateDTO dto) {
		return testimonyService.createTestimony(dto);
	}
	
	@GetMapping("testimony/get/{testimonyId}")
	public Testimony readTestimony(@PathVariable Long testimonyId) {
		return testimonyService.getTestimony(testimonyId);
	}
	
	@DeleteMapping("testimony/delete/{testimonyId}")
	public Testimony deleteTestimony(@PathVariable Long testimonyId) {
		return testimonyService.deleteTestimony(testimonyId);
	}
	
	@PostMapping("testimony/update/content")
	public Testimony updateTestimonyContent(@RequestBody TestimonyUpdateDTO dto) {
		return testimonyService.updateTestimony(dto);
	}
	
	@GetMapping("testimony/get/all")
	public List<Testimony> readTestimony() {
		return testimonyService.getTestimonyAll();
	}
	
	

}
