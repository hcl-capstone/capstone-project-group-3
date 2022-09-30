package com.hcl.commerce.service.product;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.commerce.InventoryDTO.InventoryDTO;
import com.hcl.commerce.dto.product.ProductAddDTO;
import com.hcl.commerce.dto.rating.RatingCreateDTO;
import com.hcl.commerce.dto.rating.RatingDeleteDTO;
import com.hcl.commerce.dto.rating.RatingUpdateDTO;
import com.hcl.commerce.entity.Product;
import com.hcl.commerce.entity.Rating;

@Service
public interface ProductService {

	Product addProduct(ProductAddDTO dto);

	List<Product> getAllProduct();

	Product getProduct(Long id);

	Product updateProduct(Long id, ProductAddDTO dto);

	void deleteProduct(Long id);

	List<Product> getByName(String productName);

	Product updateProductInventory(ProductAddDTO dto, InventoryDTO inventoryDTO);

	List<Rating> getRatings(Long id);

	Product addRating(RatingCreateDTO dto);

	Rating deleteRating(RatingDeleteDTO dto);

	Rating updateRating(RatingUpdateDTO dto);
}
