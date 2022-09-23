package com.hcl.commerce.service.category;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.hcl.commerce.dto.category.ProductCategoryDTO;
import com.hcl.commerce.dto.category.ProductCategoryUpdateDTO;
import com.hcl.commerce.entity.ProductCategory;
import com.hcl.commerce.repository.ProductCategoryRepository;

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
@ContextConfiguration(classes = {ProductCategoryServiceImplementation.class})
@ExtendWith(SpringExtension.class)
class ProductCategoryServiceImplementationTest {
    @MockBean
    private ProductCategoryRepository productCategoryRepository;
    @Autowired
    private ProductCategoryServiceImplementation productCategoryServiceImplementation;
    /**
     * Method under test: {@link ProductCategoryServiceImplementation#getCategory(Long)}
     */
    @Test
    void testGetCategory() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(123L);
        productCategory.setCategoryName("Category Name");
        Optional<ProductCategory> ofResult = Optional.of(productCategory);
        when(productCategoryRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(productCategory, productCategoryServiceImplementation.getCategory(123L));
        verify(productCategoryRepository).findById((Long) any());
    }
    /**
     * Method under test: {@link ProductCategoryServiceImplementation#getCategory(Long)}
     */
    @Test
    void testGetCategory2() {
        when(productCategoryRepository.findById((Long) any())).thenReturn(Optional.empty());
        assertNull(productCategoryServiceImplementation.getCategory(123L));
        verify(productCategoryRepository).findById((Long) any());
    }
    /**
     * Method under test: {@link ProductCategoryServiceImplementation#addCategory(ProductCategoryDTO)}
     */
    @Test
    void testAddCategory() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(123L);
        productCategory.setCategoryName("Category Name");
        when(productCategoryRepository.save((ProductCategory) any())).thenReturn(productCategory);
        ProductCategoryDTO productCategoryDTO = new ProductCategoryDTO();
        productCategoryDTO.setCategoryName("Category Name");
        assertSame(productCategory, productCategoryServiceImplementation.addCategory(productCategoryDTO));
        verify(productCategoryRepository).save((ProductCategory) any());
    }
    /**
     * Method under test: {@link ProductCategoryServiceImplementation#getAllProductCategory()}
     */
    @Test
    void testGetAllProductCategory() {
        ArrayList<ProductCategory> productCategoryList = new ArrayList<>();
        when(productCategoryRepository.findAll()).thenReturn(productCategoryList);
        List<ProductCategory> actualAllProductCategory = productCategoryServiceImplementation.getAllProductCategory();
        assertSame(productCategoryList, actualAllProductCategory);
        assertTrue(actualAllProductCategory.isEmpty());
        verify(productCategoryRepository).findAll();
    }
    /**
     * Method under test: {@link ProductCategoryServiceImplementation#updateCategory(ProductCategoryUpdateDTO)}
     */
    @Test
    void testUpdateCategory() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(123L);
        productCategory.setCategoryName("Category Name");
        Optional<ProductCategory> ofResult = Optional.of(productCategory);
        ProductCategory productCategory1 = new ProductCategory();
        productCategory1.setCategoryId(123L);
        productCategory1.setCategoryName("Category Name");
        when(productCategoryRepository.save((ProductCategory) any())).thenReturn(productCategory1);
        when(productCategoryRepository.findById((Long) any())).thenReturn(ofResult);
        ProductCategoryUpdateDTO productCategoryUpdateDTO = new ProductCategoryUpdateDTO();
        productCategoryUpdateDTO.setCategoryId(123L);
        productCategoryUpdateDTO.setCategoryName("Category Name");
        assertSame(productCategory1, productCategoryServiceImplementation.updateCategory(productCategoryUpdateDTO));
        verify(productCategoryRepository).save((ProductCategory) any());
        verify(productCategoryRepository).findById((Long) any());
    }
    /**
     * Method under test: {@link ProductCategoryServiceImplementation#updateCategory(ProductCategoryUpdateDTO)}
     */
    @Test
    void testUpdateCategory3() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(123L);
        productCategory.setCategoryName("Category Name");
        when(productCategoryRepository.save((ProductCategory) any())).thenReturn(productCategory);
        when(productCategoryRepository.findById((Long) any())).thenReturn(Optional.empty());
        ProductCategoryUpdateDTO productCategoryUpdateDTO = new ProductCategoryUpdateDTO();
        productCategoryUpdateDTO.setCategoryId(123L);
        productCategoryUpdateDTO.setCategoryName("Category Name");
        assertNull(productCategoryServiceImplementation.updateCategory(productCategoryUpdateDTO));
        verify(productCategoryRepository).findById((Long) any());
    }
}

