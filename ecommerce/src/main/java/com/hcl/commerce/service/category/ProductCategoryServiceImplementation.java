package com.hcl.commerce.service.category;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.commerce.dto.category.ProductCategoryDTO;
import com.hcl.commerce.dto.category.ProductCategoryUpdateDTO;
import com.hcl.commerce.entity.ProductCategory;
import com.hcl.commerce.repository.ProductCategoryRepository;

@Service
public class ProductCategoryServiceImplementation implements ProductCategoryService{

	@Autowired
	ProductCategoryRepository productCategoryRepository;
	
	@Override
	public ProductCategory getCategory(Long id) {
		Optional<ProductCategory> productCategory = productCategoryRepository.findById(id);
		if (productCategory.isPresent()) {
			return productCategory.get();
		}
		return null;
	}

	@Override
	public ProductCategory addCategory(ProductCategoryDTO dto) {
		ProductCategory category = new ProductCategory();
		BeanUtils.copyProperties(dto, category);
		return productCategoryRepository.save(category);
	}

	@Override
	public List<ProductCategory> getAllProductCategory() {
		return productCategoryRepository.findAll();
	}

	@Override
	public ProductCategory updateCategory(ProductCategoryUpdateDTO dto) {
		ProductCategory cat = getCategory(dto.getCategoryId());
		if(cat != null) {
			BeanUtils.copyProperties(dto, cat);
			return productCategoryRepository.save(cat);
		}
		return null;
	}

}
