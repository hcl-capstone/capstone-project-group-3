package com.hcl.commerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class EcommerceApplication{

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
		log.info("application started");
	}

}
