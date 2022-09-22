package com.hcl.commerce.service.product;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.commerce.InventoryDTO.InventoryDTO;
import com.hcl.commerce.dto.product.ProductAddDTO;
import com.hcl.commerce.entity.Product;

@Service
public interface ProductService {

	Product addProduct(ProductAddDTO dto);

	List<Product> getAllProduct();

	Product getProduct(Long id);

	Product updateProduct(Long id, ProductAddDTO dto);

	Product deleteProduct(Long id);

	List<Product> getByName(String productName);

	Product updateProductInventory(ProductAddDTO dto, InventoryDTO inventoryDTO);

}
