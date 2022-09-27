package com.hcl.commerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.commerce.entity.Promo;

@Repository
public interface PromoRepository extends JpaRepository<Promo, Long>{

	Optional<Promo> findByPromoCode(String id);

}
