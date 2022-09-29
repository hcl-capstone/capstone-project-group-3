package com.hcl.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.commerce.entity.Rating;

@Repository
public interface RatingRepository  extends JpaRepository<Rating, Long>{

}
