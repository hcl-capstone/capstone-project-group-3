package com.hcl.commerce.service.product;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.hcl.commerce.dto.product.ProductAddDTO;
import com.hcl.commerce.entity.Product;
import com.hcl.commerce.entity.ProductCategory;
import com.hcl.commerce.repository.ProductRepository;
import com.hcl.commerce.service.category.ProductCategoryService;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
@ContextConfiguration(classes = {ProductServiceImplementation.class})
@ExtendWith(SpringExtension.class)
class ProductServiceImplementationTest {
    @MockBean
    private ProductCategoryService productCategoryService;
    @MockBean
    private ProductRepository productRepository;
    @Autowired
    private ProductServiceImplementation productServiceImplementation;
    /**
     * Method under test: {@link ProductServiceImplementation#addProduct(ProductAddDTO)}
     */
    @Test
    void testAddProduct() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(123L);
        productCategory.setCategoryName("Category Name");
        when(productCategoryService.getCategory((Long) any())).thenReturn(productCategory);
        ProductCategory productCategory1 = new ProductCategory();
        productCategory1.setCategoryId(123L);
        productCategory1.setCategoryName("Category Name");
        Product product = new Product();
        product.setCategory(productCategory1);
        product.setDateCreated(LocalDate.ofEpochDay(1L));
        product.setDateLastUpdated(LocalDate.ofEpochDay(1L));
        product.setImage_url("https://example.org/example");
        product.setProductId(123L);
        product.setProductName("Product Name");
        product.setStockCount(3);
        product.setUnitPrice(BigDecimal.valueOf(1L));
        when(productRepository.save((Product) any())).thenReturn(product);
        Product actualAddProductResult = productServiceImplementation.addProduct(new ProductAddDTO());
        assertSame(product, actualAddProductResult);
        assertEquals("1", actualAddProductResult.getUnitPrice().toString());
        verify(productCategoryService).getCategory((Long) any());
        verify(productRepository).save((Product) any());
    }
}

