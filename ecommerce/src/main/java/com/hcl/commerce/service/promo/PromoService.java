package com.hcl.commerce.service.promo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.commerce.entity.Promo;

@Service
public interface PromoService {

	Promo getPromo(String code);

	List<Promo> getAllPromo();

	Promo deletePromo(String id);
}
