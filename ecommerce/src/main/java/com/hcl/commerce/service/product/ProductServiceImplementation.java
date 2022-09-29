package com.hcl.commerce.service.product;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.commerce.InventoryDTO.InventoryDTO;
import com.hcl.commerce.dto.product.ProductAddDTO;
import com.hcl.commerce.dto.rating.RatingCreateDTO;
import com.hcl.commerce.dto.rating.RatingDeleteDTO;
import com.hcl.commerce.dto.rating.RatingUpdateDTO;
import com.hcl.commerce.entity.Product;
import com.hcl.commerce.entity.Rating;
import com.hcl.commerce.repository.ProductRepository;
import com.hcl.commerce.service.category.ProductCategoryService;
import com.hcl.commerce.service.rating.RatingService;

@Service
public class ProductServiceImplementation implements ProductService{
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductCategoryService productCategoryService;
	
	@Autowired
	RatingService ratingService;

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
		System.out.println("get all product");
		
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
	public void deleteProduct(Long id) {
		Product product = getProduct(id);
		productRepository.delete(product);
	}

	@Override
	public List<Product> getByName(String productName) {
		
		
		List<Product> prolist = productRepository.findByProductNameContains(productName);
		for(Product product : prolist) {
			product.updateAverageRating();
			productRepository.save(product);
		}
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

	@Override
	public List<Rating> getRatings(Long id) {
		Product product = getProduct(id);
		if(product != null) {
			return product.getRatings();
		}
		return null;
	}

	@Override
	public Product addRating(RatingCreateDTO dto) {
		Product product = getProduct(dto.getProductId());
		if(product != null) {
			Rating rating = ratingService.createRating(dto);
			product.addRating(rating);
			product = productRepository.save(product);
			product.updateAverageRating();
			product = productRepository.save(product);
			return product;
		}
		return null;
	}

	@Override
	public Rating deleteRating(RatingDeleteDTO dto) {
		Product product = getProduct(dto.getProductId());
		if(product != null) {
			return ratingService.deleteRating(dto.getRatingId());
		}
		return null;
	}

	@Override
	public Rating updateRating(RatingUpdateDTO dto) {
		Product product = getProduct(dto.getProductId());
		if(product != null) {
			return ratingService.updateRating(dto);
		}
		return null;
	}

}
