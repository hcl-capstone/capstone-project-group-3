package com.hcl.commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.commerce.dto.rating.RatingCreateDTO;
import com.hcl.commerce.dto.rating.RatingUpdateDTO;
import com.hcl.commerce.entity.Rating;
import com.hcl.commerce.service.rating.RatingService;

@CrossOrigin(origins = "https://fruitilicious-frontend.azurewebsites.net")
@RestController
public class RatingController {
	
	@Autowired
	RatingService ratingService;
	
	
	//CRUD
	@PostMapping("rating/create")
	public Rating createRating(@RequestBody RatingCreateDTO dto) {
		return ratingService.createRating(dto);
	}
	
	@GetMapping("rating/get/{ratingId}")
	public Rating readRating(@PathVariable Long ratingId) {
		return ratingService.getRating(ratingId);
	}
	
	@DeleteMapping("rating/delete/{ratingId}")
	public Rating deleteRating(@PathVariable Long ratingId) {
		return ratingService.deleteRating(ratingId);
	}
	
	@PostMapping("rating/update")
	public Rating updateRatingContent(@RequestBody RatingUpdateDTO dto) {
		return ratingService.updateRating(dto);
	}
	

}
