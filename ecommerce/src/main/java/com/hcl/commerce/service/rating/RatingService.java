package com.hcl.commerce.service.rating;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.commerce.dto.rating.RatingCreateDTO;
import com.hcl.commerce.dto.rating.RatingUpdateDTO;
import com.hcl.commerce.entity.Rating;
import com.hcl.commerce.repository.RatingRepository;

@Service
public class RatingService {

	@Autowired
	RatingRepository ratingRepository;
	

	public Rating createRating(RatingCreateDTO dto) {
		Rating rating = new Rating();
		BeanUtils.copyProperties(dto, rating);
		if(rating.getRating() > 5 || rating.getRating() < 1) {
			rating.setRating(5);
		}
		return ratingRepository.save(rating);
	}

	public Rating getRating(Long ratingId) {
		Optional<Rating> rating = ratingRepository.findById(ratingId);
		if(rating.isPresent()) {
			return rating.get();
		}
		return null;
	}

	public Rating deleteRating(Long ratingId) {
		Rating rating = getRating(ratingId);
		if(rating != null) {
			ratingRepository.delete(rating);
			return rating;
		}
		return null;
	}

	public Rating updateRating(RatingUpdateDTO dto) {
		Rating rating = getRating(dto.getRatingId());
		if(rating != null) {
			BeanUtils.copyProperties(dto, rating);
			return ratingRepository.save(rating);
		}
		return null;
	}
	
	
}
