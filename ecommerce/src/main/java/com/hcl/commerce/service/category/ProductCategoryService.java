package com.hcl.commerce.service.category;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.commerce.dto.category.ProductCategoryDTO;
import com.hcl.commerce.dto.category.ProductCategoryUpdateDTO;
import com.hcl.commerce.entity.ProductCategory;

@Service
public interface ProductCategoryService {

	ProductCategory getCategory(Long id);

	ProductCategory addCategory(ProductCategoryDTO dto);

	List<ProductCategory> getAllProductCategory();

	ProductCategory updateCategory(ProductCategoryUpdateDTO dto);
}
