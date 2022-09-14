package com.hcl.commerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.commerce.dto.product.ProductAddDTO;
import com.hcl.commerce.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{


	Product save(ProductAddDTO product);
	List<Product> findByProductNameContains(String productName);

}
