package com.hcl.commerce.service.product;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.hcl.commerce.dto.product.ProductAddDTO;
import com.hcl.commerce.entity.Product;
import com.hcl.commerce.entity.ProductCategory;
import com.hcl.commerce.repository.ProductRepository;
import com.hcl.commerce.service.category.ProductCategoryService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
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
    /**
     * Method under test: {@link ProductServiceImplementation#addProduct(ProductAddDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAddProduct2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Source must not be null
        //       at org.springframework.util.Assert.notNull(Assert.java:201)
        //       at org.springframework.beans.BeanUtils.copyProperties(BeanUtils.java:782)
        //       at org.springframework.beans.BeanUtils.copyProperties(BeanUtils.java:719)
        //       at com.hcl.commerce.service.product.ProductServiceImplementation.addProduct(ProductServiceImplementation.java:29)
        //   In order to prevent addProduct(ProductAddDTO)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   addProduct(ProductAddDTO).
        //   See https://diff.blue/R013 to resolve this issue.
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
        productServiceImplementation.addProduct(null);
    }
    /**
     * Method under test: {@link ProductServiceImplementation#getAllProduct()}
     */
    @Test
    void testGetAllProduct() {
        ArrayList<Product> productList = new ArrayList<>();
        when(productRepository.findAll()).thenReturn(productList);
        List<Product> actualAllProduct = productServiceImplementation.getAllProduct();
        assertSame(productList, actualAllProduct);
        assertTrue(actualAllProduct.isEmpty());
        verify(productRepository).findAll();
    }
    /**
     * Method under test: {@link ProductServiceImplementation#getProduct(Long)}
     */
    @Test
    void testGetProduct() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(123L);
        productCategory.setCategoryName("Category Name");
        Product product = new Product();
        product.setCategory(productCategory);
        product.setDateCreated(LocalDate.ofEpochDay(1L));
        product.setDateLastUpdated(LocalDate.ofEpochDay(1L));
        product.setImage_url("https://example.org/example");
        product.setProductId(123L);
        product.setProductName("Product Name");
        product.setStockCount(3);
        product.setUnitPrice(BigDecimal.valueOf(1L));
        Optional<Product> ofResult = Optional.of(product);
        when(productRepository.findById((Long) any())).thenReturn(ofResult);
        Product actualProduct = productServiceImplementation.getProduct(123L);
        assertSame(product, actualProduct);
        assertEquals("1", actualProduct.getUnitPrice().toString());
        verify(productRepository).findById((Long) any());
    }
    /**
     * Method under test: {@link ProductServiceImplementation#getProduct(Long)}
     */
    @Test
    void testGetProduct2() {
        when(productRepository.findById((Long) any())).thenReturn(Optional.empty());
        assertNull(productServiceImplementation.getProduct(123L));
        verify(productRepository).findById((Long) any());
    }
    /**
     * Method under test: {@link ProductServiceImplementation#updateProduct(Long, ProductAddDTO)}
     */
    @Test
    void testUpdateProduct() {
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
        Optional<Product> ofResult = Optional.of(product);
        ProductCategory productCategory2 = new ProductCategory();
        productCategory2.setCategoryId(123L);
        productCategory2.setCategoryName("Category Name");
        Product product1 = new Product();
        product1.setCategory(productCategory2);
        product1.setDateCreated(LocalDate.ofEpochDay(1L));
        product1.setDateLastUpdated(LocalDate.ofEpochDay(1L));
        product1.setImage_url("https://example.org/example");
        product1.setProductId(123L);
        product1.setProductName("Product Name");
        product1.setStockCount(3);
        product1.setUnitPrice(BigDecimal.valueOf(1L));
        when(productRepository.save((Product) any())).thenReturn(product1);
        when(productRepository.findById((Long) any())).thenReturn(ofResult);
        Product actualUpdateProductResult = productServiceImplementation.updateProduct(123L, new ProductAddDTO());
        assertSame(product1, actualUpdateProductResult);
        assertEquals("1", actualUpdateProductResult.getUnitPrice().toString());
        verify(productCategoryService).getCategory((Long) any());
        verify(productRepository).save((Product) any());
        verify(productRepository).findById((Long) any());
    }
    /**
     * Method under test: {@link ProductServiceImplementation#updateProduct(Long, ProductAddDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateProduct2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Target must not be null
        //       at org.springframework.util.Assert.notNull(Assert.java:201)
        //       at org.springframework.beans.BeanUtils.copyProperties(BeanUtils.java:783)
        //       at org.springframework.beans.BeanUtils.copyProperties(BeanUtils.java:719)
        //       at com.hcl.commerce.service.product.ProductServiceImplementation.updateProduct(ProductServiceImplementation.java:53)
        //   In order to prevent updateProduct(Long, ProductAddDTO)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateProduct(Long, ProductAddDTO).
        //   See https://diff.blue/R013 to resolve this issue.
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
        when(productRepository.findById((Long) any())).thenReturn(Optional.empty());
        productServiceImplementation.updateProduct(123L, new ProductAddDTO());
    }
    /**
     * Method under test: {@link ProductServiceImplementation#deleteProduct(Long)}
     */
    @Test
    void testDeleteProduct() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(123L);
        productCategory.setCategoryName("Category Name");
        Product product = new Product();
        product.setCategory(productCategory);
        product.setDateCreated(LocalDate.ofEpochDay(1L));
        product.setDateLastUpdated(LocalDate.ofEpochDay(1L));
        product.setImage_url("https://example.org/example");
        product.setProductId(123L);
        product.setProductName("Product Name");
        product.setStockCount(3);
        product.setUnitPrice(BigDecimal.valueOf(1L));
        Optional<Product> ofResult = Optional.of(product);
        when(productRepository.findById((Long) any())).thenReturn(ofResult);
        doNothing().when(productRepository).delete((Product) any());
        Product actualDeleteProductResult = productServiceImplementation.deleteProduct(123L);
        assertSame(product, actualDeleteProductResult);
        assertEquals("1", actualDeleteProductResult.getUnitPrice().toString());
        verify(productRepository).findById((Long) any());
        verify(productRepository).delete((Product) any());
    }
    /**
     * Method under test: {@link ProductServiceImplementation#deleteProduct(Long)}
     */
    @Test
    void testDeleteProduct2() {
        when(productRepository.findById((Long) any())).thenReturn(Optional.empty());
        doNothing().when(productRepository).delete((Product) any());
        assertNull(productServiceImplementation.deleteProduct(123L));
        verify(productRepository).findById((Long) any());
        verify(productRepository).delete((Product) any());
    }
}

