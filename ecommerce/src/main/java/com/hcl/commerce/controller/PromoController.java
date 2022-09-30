package com.hcl.commerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.commerce.entity.Promo;
import com.hcl.commerce.service.promo.PromoService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "https://fruitilicious-frontend.azurewebsites.net")
@Slf4j
@RestController
public class PromoController {
	@Autowired
	PromoService serv;


	@GetMapping("promo/all")
	public List<Promo> allPromo() {
		log.info("All user_promo were requested");
		return serv.getAllPromo();
	}


	@GetMapping("promo/get/{code}")
	public Promo getPromo(@PathVariable String code) {
		log.info("Promo Code got got");
		return serv.getPromo(code);
	}

	@DeleteMapping("promo/delete/{id}")
	public Promo deletePromo(@PathVariable String id) {
		log.info("A user_promo was deleted");
		return serv.deletePromo(id);
	}


}
