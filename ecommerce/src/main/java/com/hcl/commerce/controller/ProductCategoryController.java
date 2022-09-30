package com.hcl.commerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.commerce.dto.category.ProductCategoryDTO;
import com.hcl.commerce.dto.category.ProductCategoryUpdateDTO;
import com.hcl.commerce.entity.ProductCategory;
import com.hcl.commerce.service.category.ProductCategoryService;

import lombok.extern.slf4j.Slf4j;


@CrossOrigin(origins = "https://fruitilicious-frontend.azurewebsites.net")

@Slf4j
@RestController
public class ProductCategoryController {
	@Autowired
	ProductCategoryService productCategoryService;

	@PostMapping("category/add")
	public ProductCategory addCategory(@RequestBody ProductCategoryDTO dto) {
		log.info("product_category was added");
		return productCategoryService.addCategory(dto);
	}

	@GetMapping("category/all")
	public List<ProductCategory> allCategory() {
		log.info("All product_category were listed");
		return productCategoryService.getAllProductCategory();
	}

	@PostMapping("category/update")
	public ProductCategory updateCategory(@RequestBody ProductCategoryUpdateDTO dto) {
		log.info("product_category was updated");
		return productCategoryService.updateCategory(dto);
	}

	@GetMapping("category/get/{id}")
	public ProductCategory getCategory(@PathVariable Long id) {
		log.info("product_category got got");
		return productCategoryService.getCategory(id);
	}



}
