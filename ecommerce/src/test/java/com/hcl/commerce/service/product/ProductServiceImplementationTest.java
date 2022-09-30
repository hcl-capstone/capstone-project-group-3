package com.hcl.commerce.service.product;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.hcl.commerce.InventoryDTO.InventoryDTO;
import com.hcl.commerce.dto.product.ProductAddDTO;
import com.hcl.commerce.dto.rating.RatingCreateDTO;
import com.hcl.commerce.dto.rating.RatingDeleteDTO;
import com.hcl.commerce.dto.rating.RatingUpdateDTO;
import com.hcl.commerce.entity.Product;
import com.hcl.commerce.entity.ProductCategory;
import com.hcl.commerce.entity.Rating;
import com.hcl.commerce.repository.ProductRepository;
import com.hcl.commerce.service.category.ProductCategoryService;
import com.hcl.commerce.service.rating.RatingService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    @MockBean
    private RatingService ratingService;
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
        product.setAvgrating(10.0d);
        product.setCategory(productCategory1);
        product.setDateCreated(LocalDate.ofEpochDay(1L));
        product.setDateLastUpdated(LocalDate.ofEpochDay(1L));
        product.setImage_url("https://example.org/example");
        product.setProductId(123L);
        product.setProductName("Product Name");
        product.setRatings(new ArrayList<>());
        product.setStockCount(3);
        product.setUnitPrice(BigDecimal.valueOf(1L));
        product.updateAverageRating();
        when(productRepository.save((Product) any())).thenReturn(product);
        Product actualAddProductResult = productServiceImplementation.addProduct(new ProductAddDTO());
        assertSame(product, actualAddProductResult);
        assertEquals("1", actualAddProductResult.getUnitPrice().toString());
        verify(productCategoryService).getCategory((Long) any());
        verify(productRepository).save((Product) any());
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
        product.setAvgrating(10.0d);
        product.setCategory(productCategory);
        product.setDateCreated(LocalDate.ofEpochDay(1L));
        product.setDateLastUpdated(LocalDate.ofEpochDay(1L));
        product.setImage_url("https://example.org/example");
        product.setProductId(123L);
        product.setProductName("Product Name");
        product.setRatings(new ArrayList<>());
        product.setStockCount(3);
        product.setUnitPrice(BigDecimal.valueOf(1L));
        product.updateAverageRating();
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
        product.setAvgrating(10.0d);
        product.setCategory(productCategory1);
        product.setDateCreated(LocalDate.ofEpochDay(1L));
        product.setDateLastUpdated(LocalDate.ofEpochDay(1L));
        product.setImage_url("https://example.org/example");
        product.setProductId(123L);
        product.setProductName("Product Name");
        product.setRatings(new ArrayList<>());
        product.setStockCount(3);
        product.setUnitPrice(BigDecimal.valueOf(1L));
        product.updateAverageRating();
        Optional<Product> ofResult = Optional.of(product);
        ProductCategory productCategory2 = new ProductCategory();
        productCategory2.setCategoryId(123L);
        productCategory2.setCategoryName("Category Name");
        Product product1 = new Product();
        product1.setAvgrating(10.0d);
        product1.setCategory(productCategory2);
        product1.setDateCreated(LocalDate.ofEpochDay(1L));
        product1.setDateLastUpdated(LocalDate.ofEpochDay(1L));
        product1.setImage_url("https://example.org/example");
        product1.setProductId(123L);
        product1.setProductName("Product Name");
        product1.setRatings(new ArrayList<>());
        product1.setStockCount(3);
        product1.setUnitPrice(BigDecimal.valueOf(1L));
        product1.updateAverageRating();
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
     * Method under test: {@link ProductServiceImplementation#deleteProduct(Long)}
     */
    @Test
    void testDeleteProduct() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(123L);
        productCategory.setCategoryName("Category Name");
        Product product = new Product();
        product.setAvgrating(10.0d);
        product.setCategory(productCategory);
        product.setDateCreated(LocalDate.ofEpochDay(1L));
        product.setDateLastUpdated(LocalDate.ofEpochDay(1L));
        product.setImage_url("https://example.org/example");
        product.setProductId(123L);
        product.setProductName("Product Name");
        product.setRatings(new ArrayList<>());
        product.setStockCount(3);
        product.setUnitPrice(BigDecimal.valueOf(1L));
        product.updateAverageRating();
        Optional<Product> ofResult = Optional.of(product);
        when(productRepository.findById((Long) any())).thenReturn(ofResult);
        doNothing().when(productRepository).delete((Product) any());
        productServiceImplementation.deleteProduct(123L);
        verify(productRepository).findById((Long) any());
        verify(productRepository).delete((Product) any());
        assertTrue(productServiceImplementation.getAllProduct().isEmpty());
    }
    /**
     * Method under test: {@link ProductServiceImplementation#deleteProduct(Long)}
     */
    @Test
    void testDeleteProduct2() {
        when(productRepository.findById((Long) any())).thenReturn(Optional.empty());
        doNothing().when(productRepository).delete((Product) any());
        productServiceImplementation.deleteProduct(123L);
        verify(productRepository).findById((Long) any());
        verify(productRepository).delete((Product) any());
        assertTrue(productServiceImplementation.getAllProduct().isEmpty());
    }
    /**
     * Method under test: {@link ProductServiceImplementation#getByName(String)}
     */
    @Test
    void testGetByName() {
        ArrayList<Product> productList = new ArrayList<>();
        when(productRepository.findByProductNameContains((String) any())).thenReturn(productList);
        List<Product> actualByName = productServiceImplementation.getByName("Product Name");
        assertSame(productList, actualByName);
        assertTrue(actualByName.isEmpty());
        verify(productRepository, atLeast(1)).findByProductNameContains((String) any());
    }
    /**
     * Method under test: {@link ProductServiceImplementation#getByName(String)}
     */
    @Test
    void testGetByName2() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(123L);
        productCategory.setCategoryName("Category Name");
        Product product = new Product();
        product.setAvgrating(10.0d);
        product.setCategory(productCategory);
        product.setDateCreated(LocalDate.ofEpochDay(1L));
        product.setDateLastUpdated(LocalDate.ofEpochDay(1L));
        product.setImage_url("https://example.org/example");
        product.setProductId(123L);
        product.setProductName("Product Name");
        product.setRatings(new ArrayList<>());
        product.setStockCount(3);
        product.setUnitPrice(BigDecimal.valueOf(1L));
        product.updateAverageRating();
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product);
        ProductCategory productCategory1 = new ProductCategory();
        productCategory1.setCategoryId(123L);
        productCategory1.setCategoryName("Category Name");
        Product product1 = new Product();
        product1.setAvgrating(10.0d);
        product1.setCategory(productCategory1);
        product1.setDateCreated(LocalDate.ofEpochDay(1L));
        product1.setDateLastUpdated(LocalDate.ofEpochDay(1L));
        product1.setImage_url("https://example.org/example");
        product1.setProductId(123L);
        product1.setProductName("Product Name");
        product1.setRatings(new ArrayList<>());
        product1.setStockCount(3);
        product1.setUnitPrice(BigDecimal.valueOf(1L));
        product1.updateAverageRating();
        when(productRepository.save((Product) any())).thenReturn(product1);
        when(productRepository.findByProductNameContains((String) any())).thenReturn(productList);
        List<Product> actualByName = productServiceImplementation.getByName("Product Name");
        assertSame(productList, actualByName);
        assertEquals(1, actualByName.size());
        verify(productRepository).save((Product) any());
        verify(productRepository, atLeast(1)).findByProductNameContains((String) any());
    }
    /**
     * Method under test: {@link ProductServiceImplementation#updateProductInventory(ProductAddDTO, InventoryDTO)}
     */
    @Test
    void testUpdateProductInventory() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(123L);
        productCategory.setCategoryName("Category Name");
        Product product = new Product();
        product.setAvgrating(10.0d);
        product.setCategory(productCategory);
        product.setDateCreated(LocalDate.ofEpochDay(1L));
        product.setDateLastUpdated(LocalDate.ofEpochDay(1L));
        product.setImage_url("https://example.org/example");
        product.setProductId(123L);
        product.setProductName("Product Name");
        product.setRatings(new ArrayList<>());
        product.setStockCount(3);
        product.setUnitPrice(BigDecimal.valueOf(1L));
        product.updateAverageRating();
        Optional<Product> ofResult = Optional.of(product);
        ProductCategory productCategory1 = new ProductCategory();
        productCategory1.setCategoryId(123L);
        productCategory1.setCategoryName("Category Name");
        Product product1 = new Product();
        product1.setAvgrating(10.0d);
        product1.setCategory(productCategory1);
        product1.setDateCreated(LocalDate.ofEpochDay(1L));
        product1.setDateLastUpdated(LocalDate.ofEpochDay(1L));
        product1.setImage_url("https://example.org/example");
        product1.setProductId(123L);
        product1.setProductName("Product Name");
        product1.setRatings(new ArrayList<>());
        product1.setStockCount(3);
        product1.setUnitPrice(BigDecimal.valueOf(1L));
        product1.updateAverageRating();
        when(productRepository.save((Product) any())).thenReturn(product1);
        when(productRepository.findById((Long) any())).thenReturn(ofResult);
        ProductAddDTO dto = new ProductAddDTO();
        Product actualUpdateProductInventoryResult = productServiceImplementation.updateProductInventory(dto,
                new InventoryDTO());
        assertSame(product1, actualUpdateProductInventoryResult);
        assertEquals("1", actualUpdateProductInventoryResult.getUnitPrice().toString());
        verify(productRepository).save((Product) any());
        verify(productRepository).findById((Long) any());
    }
    /**
     * Method under test: {@link ProductServiceImplementation#getRatings(Long)}
     */
    @Test
    void testGetRatings() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(123L);
        productCategory.setCategoryName("Category Name");
        Product product = new Product();
        product.setAvgrating(10.0d);
        product.setCategory(productCategory);
        product.setDateCreated(LocalDate.ofEpochDay(1L));
        product.setDateLastUpdated(LocalDate.ofEpochDay(1L));
        product.setImage_url("https://example.org/example");
        product.setProductId(123L);
        product.setProductName("Product Name");
        ArrayList<Rating> ratingList = new ArrayList<>();
        product.setRatings(ratingList);
        product.setStockCount(3);
        product.setUnitPrice(BigDecimal.valueOf(1L));
        product.updateAverageRating();
        Optional<Product> ofResult = Optional.of(product);
        when(productRepository.findById((Long) any())).thenReturn(ofResult);
        List<Rating> actualRatings = productServiceImplementation.getRatings(123L);
        assertSame(ratingList, actualRatings);
        assertTrue(actualRatings.isEmpty());
        verify(productRepository).findById((Long) any());
    }
    /**
     * Method under test: {@link ProductServiceImplementation#getRatings(Long)}
     */
    @Test
    void testGetRatings3() {
        when(productRepository.findById((Long) any())).thenReturn(Optional.empty());
        assertNull(productServiceImplementation.getRatings(123L));
        verify(productRepository).findById((Long) any());
    }
    /**
     * Method under test: {@link ProductServiceImplementation#addRating(RatingCreateDTO)}
     */
    @Test
    void testAddRating() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(123L);
        productCategory.setCategoryName("Category Name");
        Product product = new Product();
        product.setAvgrating(10.0d);
        product.setCategory(productCategory);
        product.setDateCreated(LocalDate.ofEpochDay(1L));
        product.setDateLastUpdated(LocalDate.ofEpochDay(1L));
        product.setImage_url("https://example.org/example");
        product.setProductId(123L);
        product.setProductName("Product Name");
        product.setRatings(new ArrayList<>());
        product.setStockCount(3);
        product.setUnitPrice(BigDecimal.valueOf(1L));
        product.updateAverageRating();
        Optional<Product> ofResult = Optional.of(product);
        ProductCategory productCategory1 = new ProductCategory();
        productCategory1.setCategoryId(123L);
        productCategory1.setCategoryName("Category Name");
        Product product1 = new Product();
        product1.setAvgrating(10.0d);
        product1.setCategory(productCategory1);
        product1.setDateCreated(LocalDate.ofEpochDay(1L));
        product1.setDateLastUpdated(LocalDate.ofEpochDay(1L));
        product1.setImage_url("https://example.org/example");
        product1.setProductId(123L);
        product1.setProductName("Product Name");
        product1.setRatings(new ArrayList<>());
        product1.setStockCount(3);
        product1.setUnitPrice(BigDecimal.valueOf(1L));
        product1.updateAverageRating();
        when(productRepository.save((Product) any())).thenReturn(product1);
        when(productRepository.findById((Long) any())).thenReturn(ofResult);
        Rating rating = new Rating();
        rating.setName("Name");
        rating.setRating(1);
        rating.setRatingId(123L);
        rating.setTestimony("Testimony");
        when(ratingService.createRating((RatingCreateDTO) any())).thenReturn(rating);
        RatingCreateDTO ratingCreateDTO = new RatingCreateDTO();
        ratingCreateDTO.setName("Name");
        ratingCreateDTO.setProductId(123L);
        ratingCreateDTO.setRating(1);
        ratingCreateDTO.setTestimony("Testimony");
        Product actualAddRatingResult = productServiceImplementation.addRating(ratingCreateDTO);
        assertSame(product1, actualAddRatingResult);
        assertEquals(5.0d, actualAddRatingResult.getAvgrating().doubleValue());
        assertEquals("1", actualAddRatingResult.getUnitPrice().toString());
        verify(productRepository, atLeast(1)).save((Product) any());
        verify(productRepository).findById((Long) any());
        verify(ratingService).createRating((RatingCreateDTO) any());
    }
    /**
     * Method under test: {@link ProductServiceImplementation#addRating(RatingCreateDTO)}
     */
    @Test
    void testAddRating3() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(123L);
        productCategory.setCategoryName("Category Name");
        Product product = new Product();
        product.setAvgrating(10.0d);
        product.setCategory(productCategory);
        product.setDateCreated(LocalDate.ofEpochDay(1L));
        product.setDateLastUpdated(LocalDate.ofEpochDay(1L));
        product.setImage_url("https://example.org/example");
        product.setProductId(123L);
        product.setProductName("Product Name");
        product.setRatings(new ArrayList<>());
        product.setStockCount(3);
        product.setUnitPrice(BigDecimal.valueOf(1L));
        product.updateAverageRating();
        when(productRepository.save((Product) any())).thenReturn(product);
        when(productRepository.findById((Long) any())).thenReturn(Optional.empty());
        Rating rating = new Rating();
        rating.setName("Name");
        rating.setRating(1);
        rating.setRatingId(123L);
        rating.setTestimony("Testimony");
        when(ratingService.createRating((RatingCreateDTO) any())).thenReturn(rating);
        RatingCreateDTO ratingCreateDTO = new RatingCreateDTO();
        ratingCreateDTO.setName("Name");
        ratingCreateDTO.setProductId(123L);
        ratingCreateDTO.setRating(1);
        ratingCreateDTO.setTestimony("Testimony");
        assertNull(productServiceImplementation.addRating(ratingCreateDTO));
        verify(productRepository).findById((Long) any());
    }
    /**
     * Method under test: {@link ProductServiceImplementation#deleteRating(RatingDeleteDTO)}
     */
    @Test
    void testDeleteRating() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(123L);
        productCategory.setCategoryName("Category Name");
        Product product = new Product();
        product.setAvgrating(10.0d);
        product.setCategory(productCategory);
        product.setDateCreated(LocalDate.ofEpochDay(1L));
        product.setDateLastUpdated(LocalDate.ofEpochDay(1L));
        product.setImage_url("https://example.org/example");
        product.setProductId(123L);
        product.setProductName("Product Name");
        product.setRatings(new ArrayList<>());
        product.setStockCount(3);
        product.setUnitPrice(BigDecimal.valueOf(1L));
        product.updateAverageRating();
        Optional<Product> ofResult = Optional.of(product);
        when(productRepository.findById((Long) any())).thenReturn(ofResult);
        Rating rating = new Rating();
        rating.setName("Name");
        rating.setRating(1);
        rating.setRatingId(123L);
        rating.setTestimony("Testimony");
        when(ratingService.deleteRating((Long) any())).thenReturn(rating);
        RatingDeleteDTO ratingDeleteDTO = new RatingDeleteDTO();
        ratingDeleteDTO.setProductId(123L);
        ratingDeleteDTO.setRatingId(123L);
        assertSame(rating, productServiceImplementation.deleteRating(ratingDeleteDTO));
        verify(productRepository).findById((Long) any());
        verify(ratingService).deleteRating((Long) any());
    }
    /**
     * Method under test: {@link ProductServiceImplementation#deleteRating(RatingDeleteDTO)}
     */
    @Test
    void testDeleteRating3() {
        when(productRepository.findById((Long) any())).thenReturn(Optional.empty());
        Rating rating = new Rating();
        rating.setName("Name");
        rating.setRating(1);
        rating.setRatingId(123L);
        rating.setTestimony("Testimony");
        when(ratingService.deleteRating((Long) any())).thenReturn(rating);
        RatingDeleteDTO ratingDeleteDTO = new RatingDeleteDTO();
        ratingDeleteDTO.setProductId(123L);
        ratingDeleteDTO.setRatingId(123L);
        assertNull(productServiceImplementation.deleteRating(ratingDeleteDTO));
        verify(productRepository).findById((Long) any());
    }
    /**
     * Method under test: {@link ProductServiceImplementation#updateRating(RatingUpdateDTO)}
     */
    @Test
    void testUpdateRating() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(123L);
        productCategory.setCategoryName("Category Name");
        Product product = new Product();
        product.setAvgrating(10.0d);
        product.setCategory(productCategory);
        product.setDateCreated(LocalDate.ofEpochDay(1L));
        product.setDateLastUpdated(LocalDate.ofEpochDay(1L));
        product.setImage_url("https://example.org/example");
        product.setProductId(123L);
        product.setProductName("Product Name");
        product.setRatings(new ArrayList<>());
        product.setStockCount(3);
        product.setUnitPrice(BigDecimal.valueOf(1L));
        product.updateAverageRating();
        Optional<Product> ofResult = Optional.of(product);
        when(productRepository.findById((Long) any())).thenReturn(ofResult);
        Rating rating = new Rating();
        rating.setName("Name");
        rating.setRating(1);
        rating.setRatingId(123L);
        rating.setTestimony("Testimony");
        when(ratingService.updateRating((RatingUpdateDTO) any())).thenReturn(rating);
        RatingUpdateDTO ratingUpdateDTO = new RatingUpdateDTO();
        ratingUpdateDTO.setName("Name");
        ratingUpdateDTO.setProductId(123L);
        ratingUpdateDTO.setRating(1);
        ratingUpdateDTO.setRatingId(123L);
        ratingUpdateDTO.setTestimony("Testimony");
        assertSame(rating, productServiceImplementation.updateRating(ratingUpdateDTO));
        verify(productRepository).findById((Long) any());
        verify(ratingService).updateRating((RatingUpdateDTO) any());
    }
    /**
     * Method under test: {@link ProductServiceImplementation#updateRating(RatingUpdateDTO)}
     */
    @Test
    void testUpdateRating3() {
        when(productRepository.findById((Long) any())).thenReturn(Optional.empty());
        Rating rating = new Rating();
        rating.setName("Name");
        rating.setRating(1);
        rating.setRatingId(123L);
        rating.setTestimony("Testimony");
        when(ratingService.updateRating((RatingUpdateDTO) any())).thenReturn(rating);
        RatingUpdateDTO ratingUpdateDTO = new RatingUpdateDTO();
        ratingUpdateDTO.setName("Name");
        ratingUpdateDTO.setProductId(123L);
        ratingUpdateDTO.setRating(1);
        ratingUpdateDTO.setRatingId(123L);
        ratingUpdateDTO.setTestimony("Testimony");
        assertNull(productServiceImplementation.updateRating(ratingUpdateDTO));
        verify(productRepository).findById((Long) any());
    }
}

