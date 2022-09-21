package com.hcl.commerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.commerce.dto.product.ProductAddDTO;
import com.hcl.commerce.entity.Product;
import com.hcl.commerce.service.product.ProductService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "https://fruitilicious-frontend.azurewebsites.net")
@Slf4j
@RestController
public class ProductController {
	@Autowired
	ProductService productService;
	
	@PostMapping("product/add")
	public Product addProduct(@RequestBody ProductAddDTO dto) {
		log.info("Admin added product");
		return productService.addProduct(dto);
	}
	
	@DeleteMapping("product/delete/{id}")
	public Product deleteProduct(@PathVariable Long id) {
		log.info("Admin deleted product by productId");
		return productService.deleteProduct(id);
	}
	
	@PostMapping("product/update/{id}")
	public Product updateProduct(@RequestBody ProductAddDTO dto, @PathVariable Long id) {
		log.info("Admin updated product by productId");
		return productService.updateProduct(id, dto);
	}
	
	@GetMapping("product/get/{id}")
	public Product getProduct(@PathVariable Long id) {
		log.info("User requested for the productId");
		return productService.getProduct(id);
	}
	
	@GetMapping("product/all")
	public List<Product> getProduct() {
		log.info("User requests all product");
		return productService.getAllProduct();
	}
	
	@GetMapping("product/get/byName")
	public List<Product> getByName (@RequestParam String name)	{
		log.info("User gets product by name");
		return productService.getByName(name);
	}
	

	
}
