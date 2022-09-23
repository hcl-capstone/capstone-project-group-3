package com.hcl.commerce.service.shoppingcart;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.hcl.commerce.dto.shoppingcart.CartCreateDTO;
import com.hcl.commerce.dto.shoppingcart.CartUpdateDTO;
import com.hcl.commerce.entity.Product;
import com.hcl.commerce.entity.ProductCategory;
import com.hcl.commerce.entity.ShoppingCart;
import com.hcl.commerce.repository.ShoppingCartRepository;
import com.hcl.commerce.service.product.ProductService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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
    private RabbitTemplate rabbitTemplate;
    @MockBean
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private ShoppingCartServiceImplementation shoppingCartServiceImplementation;
    /**
     * Method under test: {@link ShoppingCartServiceImplementation#createCart(CartCreateDTO)}
     */
    @Test
    void testCreateCart() throws AmqpException {
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
        shoppingCart.setCartPrice(BigDecimal.valueOf(1L));
        shoppingCart.setProduct(product1);
        shoppingCart.setProductQuantity(1);
        shoppingCart.updateCartPrice();
        when(shoppingCartRepository.save((ShoppingCart) any())).thenReturn(shoppingCart);
        doNothing().when(rabbitTemplate).convertAndSend((String) any(), (String) any(), (Object) any());
        CartCreateDTO cartCreateDTO = new CartCreateDTO();
        cartCreateDTO.setProductId(123L);
        cartCreateDTO.setProductQuantity(1);
        ShoppingCart actualCreateCartResult = shoppingCartServiceImplementation.createCart(cartCreateDTO);
        assertSame(shoppingCart, actualCreateCartResult);
        assertEquals("1", actualCreateCartResult.getProductCost().toString());
        verify(productService, atLeast(1)).getProduct((Long) any());
        verify(shoppingCartRepository).save((ShoppingCart) any());
        verify(rabbitTemplate).convertAndSend((String) any(), (String) any(), (Object) any());
    }
    /**
     * Method under test: {@link ShoppingCartServiceImplementation#createCart(CartCreateDTO)}
     */
    @Test
    void testCreateCart2() throws AmqpException {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(123L);
        productCategory.setCategoryName("Category Name");
        Product product = mock(Product.class);
        when(product.getStockCount()).thenReturn(Integer.MIN_VALUE);
        when(product.getProductId()).thenReturn(123L);
        when(product.getUnitPrice()).thenReturn(BigDecimal.valueOf(1L));
        doNothing().when(product).setCategory((ProductCategory) any());
        doNothing().when(product).setDateCreated((LocalDate) any());
        doNothing().when(product).setDateLastUpdated((LocalDate) any());
        doNothing().when(product).setImage_url((String) any());
        doNothing().when(product).setProductId((Long) any());
        doNothing().when(product).setProductName((String) any());
        doNothing().when(product).setStockCount(anyInt());
        doNothing().when(product).setUnitPrice((BigDecimal) any());
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
        shoppingCart.setCartPrice(BigDecimal.valueOf(1L));
        shoppingCart.setProduct(product1);
        shoppingCart.setProductQuantity(1);
        shoppingCart.updateCartPrice();
        when(shoppingCartRepository.save((ShoppingCart) any())).thenReturn(shoppingCart);
        doNothing().when(rabbitTemplate).convertAndSend((String) any(), (String) any(), (Object) any());
        CartCreateDTO cartCreateDTO = new CartCreateDTO();
        cartCreateDTO.setProductId(123L);
        cartCreateDTO.setProductQuantity(1);
        ShoppingCart actualCreateCartResult = shoppingCartServiceImplementation.createCart(cartCreateDTO);
        assertSame(shoppingCart, actualCreateCartResult);
        assertEquals("1", actualCreateCartResult.getProductCost().toString());
        verify(productService, atLeast(1)).getProduct((Long) any());
        verify(product).getStockCount();
        verify(product).getUnitPrice();
        verify(product).setCategory((ProductCategory) any());
        verify(product).setDateCreated((LocalDate) any());
        verify(product).setDateLastUpdated((LocalDate) any());
        verify(product).setImage_url((String) any());
        verify(product).setProductId((Long) any());
        verify(product).setProductName((String) any());
        verify(product).setStockCount(anyInt());
        verify(product).setUnitPrice((BigDecimal) any());
        verify(shoppingCartRepository).save((ShoppingCart) any());
    }
    /**
     * Method under test: {@link ShoppingCartServiceImplementation#readCart(Long)}
     */
    @Test
    void testReadCart() {
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
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCartId(123L);
        shoppingCart.setCartPrice(BigDecimal.valueOf(1L));
        shoppingCart.setProduct(product);
        shoppingCart.setProductQuantity(1);
        shoppingCart.updateCartPrice();
        Optional<ShoppingCart> ofResult = Optional.of(shoppingCart);
        when(shoppingCartRepository.findById((Long) any())).thenReturn(ofResult);
        ShoppingCart actualReadCartResult = shoppingCartServiceImplementation.readCart(123L);
        assertSame(shoppingCart, actualReadCartResult);
        assertEquals("1", actualReadCartResult.getProductCost().toString());
        verify(shoppingCartRepository).findById((Long) any());
    }
    /**
     * Method under test: {@link ShoppingCartServiceImplementation#readCart(Long)}
     */
    @Test
    void testReadCart2() {
        when(shoppingCartRepository.findById((Long) any())).thenReturn(Optional.empty());
        assertNull(shoppingCartServiceImplementation.readCart(123L));
        verify(shoppingCartRepository).findById((Long) any());
    }
    /**
     * Method under test: {@link ShoppingCartServiceImplementation#deleteCart(Long)}
     */
    @Test
    void testDeleteCart() {
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
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCartId(123L);
        shoppingCart.setCartPrice(BigDecimal.valueOf(1L));
        shoppingCart.setProduct(product);
        shoppingCart.setProductQuantity(1);
        shoppingCart.updateCartPrice();
        Optional<ShoppingCart> ofResult = Optional.of(shoppingCart);
        doNothing().when(shoppingCartRepository).delete((ShoppingCart) any());
        when(shoppingCartRepository.findById((Long) any())).thenReturn(ofResult);
        ShoppingCart actualDeleteCartResult = shoppingCartServiceImplementation.deleteCart(123L);
        assertSame(shoppingCart, actualDeleteCartResult);
        assertEquals("1", actualDeleteCartResult.getProductCost().toString());
        verify(shoppingCartRepository).findById((Long) any());
        verify(shoppingCartRepository).delete((ShoppingCart) any());
    }
    /**
     * Method under test: {@link ShoppingCartServiceImplementation#deleteCart(Long)}
     */
    @Test
    void testDeleteCart3() {
        doNothing().when(shoppingCartRepository).delete((ShoppingCart) any());
        when(shoppingCartRepository.findById((Long) any())).thenReturn(Optional.empty());
        assertNull(shoppingCartServiceImplementation.deleteCart(123L));
        verify(shoppingCartRepository).findById((Long) any());
    }
    /**
     * Method under test: {@link ShoppingCartServiceImplementation#updateCart(CartUpdateDTO)}
     */
    @Test
    void testUpdateCart() {
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
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCartId(123L);
        shoppingCart.setCartPrice(BigDecimal.valueOf(1L));
        shoppingCart.setProduct(product);
        shoppingCart.setProductQuantity(1);
        shoppingCart.updateCartPrice();
        Optional<ShoppingCart> ofResult = Optional.of(shoppingCart);
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
        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart1.setCartId(123L);
        shoppingCart1.setCartPrice(BigDecimal.valueOf(1L));
        shoppingCart1.setProduct(product1);
        shoppingCart1.setProductQuantity(1);
        shoppingCart1.updateCartPrice();
        when(shoppingCartRepository.save((ShoppingCart) any())).thenReturn(shoppingCart1);
        when(shoppingCartRepository.findById((Long) any())).thenReturn(ofResult);
        CartUpdateDTO cartUpdateDTO = new CartUpdateDTO();
        cartUpdateDTO.setCartId(123L);
        cartUpdateDTO.setProductQuantity(1);
        ShoppingCart actualUpdateCartResult = shoppingCartServiceImplementation.updateCart(cartUpdateDTO);
        assertSame(shoppingCart1, actualUpdateCartResult);
        assertEquals("1", actualUpdateCartResult.getProductCost().toString());
        verify(shoppingCartRepository).save((ShoppingCart) any());
        verify(shoppingCartRepository).findById((Long) any());
    }
    /**
     * Method under test: {@link ShoppingCartServiceImplementation#updateCart(CartUpdateDTO)}
     */
    @Test
    void testUpdateCart3() {
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
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCartId(123L);
        shoppingCart.setCartPrice(BigDecimal.valueOf(1L));
        shoppingCart.setProduct(product);
        shoppingCart.setProductQuantity(1);
        shoppingCart.updateCartPrice();
        when(shoppingCartRepository.save((ShoppingCart) any())).thenReturn(shoppingCart);
        when(shoppingCartRepository.findById((Long) any())).thenReturn(Optional.empty());
        CartUpdateDTO cartUpdateDTO = new CartUpdateDTO();
        cartUpdateDTO.setCartId(123L);
        cartUpdateDTO.setProductQuantity(1);
        assertNull(shoppingCartServiceImplementation.updateCart(cartUpdateDTO));
        verify(shoppingCartRepository).findById((Long) any());
    }
    /**
     * Method under test: {@link ShoppingCartServiceImplementation#saveCart(ShoppingCart)}
     */
    @Test
    void testSaveCart() {
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
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCartId(123L);
        shoppingCart.setCartPrice(BigDecimal.valueOf(1L));
        shoppingCart.setProduct(product);
        shoppingCart.setProductQuantity(1);
        shoppingCart.updateCartPrice();
        when(shoppingCartRepository.save((ShoppingCart) any())).thenReturn(shoppingCart);
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
        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart1.setCartId(123L);
        shoppingCart1.setCartPrice(BigDecimal.valueOf(1L));
        shoppingCart1.setProduct(product1);
        shoppingCart1.setProductQuantity(1);
        shoppingCart1.updateCartPrice();
        ShoppingCart actualSaveCartResult = shoppingCartServiceImplementation.saveCart(shoppingCart1);
        assertSame(shoppingCart, actualSaveCartResult);
        assertEquals("1", actualSaveCartResult.getProductCost().toString());
        verify(shoppingCartRepository).save((ShoppingCart) any());
    }
}

