package com.hcl.commerce.service.shoppingcart;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.hcl.commerce.dto.shoppingcart.CartCreateDTO;
import com.hcl.commerce.entity.Product;
import com.hcl.commerce.entity.ProductCategory;
import com.hcl.commerce.entity.ShoppingCart;
import com.hcl.commerce.repository.ShoppingCartRepository;
import com.hcl.commerce.service.product.ProductService;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
@ContextConfiguration(classes = {ShoppingCartServiceImplementation.class})
@ExtendWith(SpringExtension.class)
class ShoppingCartServiceImplementationTest {
    @MockBean
    private ProductService productService;
    @MockBean
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private ShoppingCartServiceImplementation shoppingCartServiceImplementation;
    /**
     * Method under test: {@link ShoppingCartServiceImplementation#createCart(CartCreateDTO)}
     */
    @Test
    void testCreateCart() {
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
        when(productService.getProduct((Long) any())).thenReturn(product);
        ProductCategory productCategory1 = new ProductCategory();
        productCategory1.setCategoryId(123L);
        productCategory1.setCategoryName("Category Name");
        Product product1 = new Product();
        product1.setCategory(productCategory1);
        product1.setDateCreated(LocalDate.ofEpochDay(1L));
        product1.setDateLastUpdated(LocalDate.ofEpochDay(1L));
        product1.setImage_url("https://example.org/example");
        product1.setProductId(123L);
        product1.setProductName("Product Name");
        product1.setStockCount(3);
        product1.setUnitPrice(BigDecimal.valueOf(1L));
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCartId(123L);
        shoppingCart.setProduct(product1);
        shoppingCart.setProductQuantity(1);
        when(shoppingCartRepository.save((ShoppingCart) any())).thenReturn(shoppingCart);
        CartCreateDTO cartCreateDTO = new CartCreateDTO();
        cartCreateDTO.setProductId(123L);
        cartCreateDTO.setProductQuantity(1);
        ShoppingCart actualCreateCartResult = shoppingCartServiceImplementation.createCart(cartCreateDTO);
        assertSame(shoppingCart, actualCreateCartResult);
        assertEquals("1", actualCreateCartResult.getProductCost().toString());
        verify(productService).getProduct((Long) any());
        verify(shoppingCartRepository).save((ShoppingCart) any());
    }
}

