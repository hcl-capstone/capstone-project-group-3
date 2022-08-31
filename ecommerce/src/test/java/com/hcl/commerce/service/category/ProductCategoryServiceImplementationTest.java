package com.hcl.commerce.service.category;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.hcl.commerce.dto.category.ProductCategoryDTO;
import com.hcl.commerce.entity.ProductCategory;
import com.hcl.commerce.repository.ProductCategoryRepository;
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
}

