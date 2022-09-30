package com.hcl.commerce.service.promo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.commerce.entity.Promo;
import com.hcl.commerce.repository.PromoRepository;

@Service
public class PromoServiceImplementation implements PromoService{

	@Autowired
	PromoRepository repo;
	
	@Override
	public Promo getPromo(String id) {
		Optional<Promo> promo = repo.findByPromoCode(id);
		if (promo.isPresent()) {
			return promo.get();
		}
		return null;
	}


	@Override
	public List<Promo> getAllPromo() {
		return repo.findAll();
	}


	@Override
	public Promo deletePromo(String id) {
		Promo promo = getPromo(id);
		repo.delete(promo);
		return promo;
	}

}
