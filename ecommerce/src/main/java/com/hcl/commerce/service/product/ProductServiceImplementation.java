package com.hcl.commerce.service.product;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.commerce.InventoryDTO.InventoryDTO;
import com.hcl.commerce.dto.product.ProductAddDTO;
import com.hcl.commerce.entity.Product;
import com.hcl.commerce.repository.ProductRepository;
import com.hcl.commerce.service.category.ProductCategoryService;

@Service
public class ProductServiceImplementation implements ProductService{
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductCategoryService productCategoryService;

	@Override
	public Product addProduct(ProductAddDTO dto) {
		Product product = new Product();
		BeanUtils.copyProperties(dto, product);
		product.setCategory(productCategoryService.getCategory(dto.getCategory()));
		product.setDateCreated(LocalDate.now());
		product.setDateLastUpdated(LocalDate.now());
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public Product getProduct(Long id) {
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent()) {
			return product.get();
		}
		return null;
	}

	@Override
	public Product updateProduct(Long id, ProductAddDTO dto) {
		Product product = getProduct(id);
		BeanUtils.copyProperties(dto, product);
		product.setCategory(productCategoryService.getCategory(dto.getCategory()));
		product.setDateLastUpdated(LocalDate.now());
		return productRepository.save(product);
	}

	@Override
	public Product deleteProduct(Long id) {
		Product product = getProduct(id);
		productRepository.delete(product);
		return product;
	}

	@Override
	public List<Product> getByName(String productName) {
		
		return productRepository.findByProductNameContains(productName);
		
//		Optional<Product> product = productRepository.findByProductNameContaining(productName);
//		if (product.isPresent()) {
//			return (List<Product>) product.get();
//		}
//		return null;
	}
	
	@Override
    public Product updateProductInventory( ProductAddDTO dto, InventoryDTO inventoryDTO) {
        Product product = getProduct(inventoryDTO.getProductId());
        product.setStockCount(inventoryDTO.getStock_count() + 100);
        product.setDateLastUpdated(LocalDate.now());
        return productRepository.save(product);
    }

}
