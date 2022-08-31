package com.hcl.commerce.service.invoice;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.hcl.commerce.dto.address.AddressCreateDTO;
import com.hcl.commerce.dto.shoppingcart.CartCreateDTO;
import com.hcl.commerce.dto.shoppingcart.CartUpdateDTO;
import com.hcl.commerce.entity.Address;
import com.hcl.commerce.entity.Invoice;
import com.hcl.commerce.entity.Product;
import com.hcl.commerce.entity.ProductCategory;
import com.hcl.commerce.entity.ShoppingCart;
import com.hcl.commerce.repository.InvoiceRepository;
import com.hcl.commerce.service.address.AddressService;
import com.hcl.commerce.service.product.ProductService;
import com.hcl.commerce.service.shoppingcart.ShoppingCartService;
import com.hcl.commerce.service.user.UserService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
@ContextConfiguration(classes = {InvoiceSupportService.class})
@ExtendWith(SpringExtension.class)
class InvoiceSupportServiceTest {
    @MockBean
    private AddressService addressService;
    @MockBean
    private InvoiceRepository invoiceRepository;
    @MockBean
    private InvoiceService invoiceService;
    @Autowired
    private InvoiceSupportService invoiceSupportService;
    @MockBean
    private ProductService productService;
    @MockBean
    private ShoppingCartService shoppingCartService;
    @MockBean
    private UserService userService;
    /**
     * Method under test: {@link InvoiceSupportService#addInvoiceCart(Long, CartCreateDTO)}
     */
    @Test
    void testAddInvoiceCart() {
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
        shoppingCart.setProduct(product);
        shoppingCart.setProductQuantity(1);
        when(shoppingCartService.createCart((CartCreateDTO) any())).thenReturn(shoppingCart);
        Address address = new Address();
        address.setAddressId(123L);
        address.setCity("Oxford");
        address.setCountry("GB");
        address.setSecondary("Secondary");
        address.setState("MD");
        address.setStreet("Street");
        address.setZip("21654");
        Invoice invoice = new Invoice();
        invoice.setAddress(address);
        invoice.setCarts(new ArrayList<>());
        invoice.setDateOrdered(LocalDate.ofEpochDay(1L));
        invoice.setInvoiceId(123L);
        invoice.setOrderStatus("Order Status");
        invoice.setTotalPrice(BigDecimal.valueOf(1L));
        invoice.updateTotalPrice();
        Address address1 = new Address();
        address1.setAddressId(123L);
        address1.setCity("Oxford");
        address1.setCountry("GB");
        address1.setSecondary("Secondary");
        address1.setState("MD");
        address1.setStreet("Street");
        address1.setZip("21654");
        Invoice invoice1 = new Invoice();
        invoice1.setAddress(address1);
        invoice1.setCarts(new ArrayList<>());
        invoice1.setDateOrdered(LocalDate.ofEpochDay(1L));
        invoice1.setInvoiceId(123L);
        invoice1.setOrderStatus("Order Status");
        invoice1.setTotalPrice(BigDecimal.valueOf(1L));
        invoice1.updateTotalPrice();
        when(invoiceService.updateInvoice((Long) any())).thenReturn(invoice1);
        when(invoiceService.getInvoice((Long) any())).thenReturn(invoice);
        Address address2 = new Address();
        address2.setAddressId(123L);
        address2.setCity("Oxford");
        address2.setCountry("GB");
        address2.setSecondary("Secondary");
        address2.setState("MD");
        address2.setStreet("Street");
        address2.setZip("21654");
        Invoice invoice2 = new Invoice();
        invoice2.setAddress(address2);
        invoice2.setCarts(new ArrayList<>());
        invoice2.setDateOrdered(LocalDate.ofEpochDay(1L));
        invoice2.setInvoiceId(123L);
        invoice2.setOrderStatus("Order Status");
        invoice2.setTotalPrice(BigDecimal.valueOf(1L));
        invoice2.updateTotalPrice();
        when(invoiceRepository.save((Invoice) any())).thenReturn(invoice2);
        CartCreateDTO cartCreateDTO = new CartCreateDTO();
        cartCreateDTO.setProductId(123L);
        cartCreateDTO.setProductQuantity(1);
        Invoice actualAddInvoiceCartResult = invoiceSupportService.addInvoiceCart(1L, cartCreateDTO);
        assertSame(invoice1, actualAddInvoiceCartResult);
        assertEquals("0", actualAddInvoiceCartResult.getTotalPrice().toString());
        verify(shoppingCartService).createCart((CartCreateDTO) any());
        verify(invoiceService).getInvoice((Long) any());
        verify(invoiceService).updateInvoice((Long) any());
        verify(invoiceRepository).save((Invoice) any());
    }
    /**
     * Method under test: {@link InvoiceSupportService#deleteInvoiceCart(Long, Long)}
     */
    @Test
    void testDeleteInvoiceCart() {
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
        shoppingCart.setProduct(product);
        shoppingCart.setProductQuantity(1);
        when(shoppingCartService.deleteCart((Long) any())).thenReturn(shoppingCart);
        Address address = new Address();
        address.setAddressId(123L);
        address.setCity("Oxford");
        address.setCountry("GB");
        address.setSecondary("Secondary");
        address.setState("MD");
        address.setStreet("Street");
        address.setZip("21654");
        Invoice invoice = new Invoice();
        invoice.setAddress(address);
        invoice.setCarts(new ArrayList<>());
        invoice.setDateOrdered(LocalDate.ofEpochDay(1L));
        invoice.setInvoiceId(123L);
        invoice.setOrderStatus("Order Status");
        invoice.setTotalPrice(BigDecimal.valueOf(1L));
        invoice.updateTotalPrice();
        when(invoiceService.getInvoice((Long) any())).thenReturn(invoice);
        Address address1 = new Address();
        address1.setAddressId(123L);
        address1.setCity("Oxford");
        address1.setCountry("GB");
        address1.setSecondary("Secondary");
        address1.setState("MD");
        address1.setStreet("Street");
        address1.setZip("21654");
        Invoice invoice1 = new Invoice();
        invoice1.setAddress(address1);
        invoice1.setCarts(new ArrayList<>());
        invoice1.setDateOrdered(LocalDate.ofEpochDay(1L));
        invoice1.setInvoiceId(123L);
        invoice1.setOrderStatus("Order Status");
        invoice1.setTotalPrice(BigDecimal.valueOf(1L));
        invoice1.updateTotalPrice();
        when(invoiceRepository.save((Invoice) any())).thenReturn(invoice1);
        Invoice actualDeleteInvoiceCartResult = invoiceSupportService.deleteInvoiceCart(1L, 1L);
        assertSame(invoice1, actualDeleteInvoiceCartResult);
        assertEquals("0", actualDeleteInvoiceCartResult.getTotalPrice().toString());
        verify(shoppingCartService).deleteCart((Long) any());
        verify(invoiceService).getInvoice((Long) any());
        verify(invoiceRepository).save((Invoice) any());
    }
    /**
     * Method under test: {@link InvoiceSupportService#updateInvoiceCart(CartUpdateDTO)}
     */
    @Test
    void testUpdateInvoiceCart() {
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
        shoppingCart.setProduct(product);
        shoppingCart.setProductQuantity(1);
        when(shoppingCartService.updateCart((CartUpdateDTO) any())).thenReturn(shoppingCart);
        CartUpdateDTO cartUpdateDTO = new CartUpdateDTO();
        cartUpdateDTO.setCartId(123L);
        cartUpdateDTO.setProductQuantity(1);
        ShoppingCart actualUpdateInvoiceCartResult = invoiceSupportService.updateInvoiceCart(cartUpdateDTO);
        assertSame(shoppingCart, actualUpdateInvoiceCartResult);
        assertEquals("1", actualUpdateInvoiceCartResult.getProductCost().toString());
        verify(shoppingCartService).updateCart((CartUpdateDTO) any());
    }
    /**
     * Method under test: {@link InvoiceSupportService#addAddressToInvoice(Long, AddressCreateDTO)}
     */
    @Test
    void testAddAddressToInvoice() {
        Address address = new Address();
        address.setAddressId(123L);
        address.setCity("Oxford");
        address.setCountry("GB");
        address.setSecondary("Secondary");
        address.setState("MD");
        address.setStreet("Street");
        address.setZip("21654");
        when(addressService.addAddress((AddressCreateDTO) any())).thenReturn(address);
        Address address1 = new Address();
        address1.setAddressId(123L);
        address1.setCity("Oxford");
        address1.setCountry("GB");
        address1.setSecondary("Secondary");
        address1.setState("MD");
        address1.setStreet("Street");
        address1.setZip("21654");
        Invoice invoice = new Invoice();
        invoice.setAddress(address1);
        invoice.setCarts(new ArrayList<>());
        invoice.setDateOrdered(LocalDate.ofEpochDay(1L));
        invoice.setInvoiceId(123L);
        invoice.setOrderStatus("Order Status");
        invoice.setTotalPrice(BigDecimal.valueOf(1L));
        invoice.updateTotalPrice();
        when(invoiceService.getInvoice((Long) any())).thenReturn(invoice);
        Address address2 = new Address();
        address2.setAddressId(123L);
        address2.setCity("Oxford");
        address2.setCountry("GB");
        address2.setSecondary("Secondary");
        address2.setState("MD");
        address2.setStreet("Street");
        address2.setZip("21654");
        Invoice invoice1 = new Invoice();
        invoice1.setAddress(address2);
        invoice1.setCarts(new ArrayList<>());
        invoice1.setDateOrdered(LocalDate.ofEpochDay(1L));
        invoice1.setInvoiceId(123L);
        invoice1.setOrderStatus("Order Status");
        invoice1.setTotalPrice(BigDecimal.valueOf(1L));
        invoice1.updateTotalPrice();
        when(invoiceRepository.save((Invoice) any())).thenReturn(invoice1);
        AddressCreateDTO addressCreateDTO = new AddressCreateDTO();
        addressCreateDTO.setCity("Oxford");
        addressCreateDTO.setCountry("GB");
        addressCreateDTO.setSecondary("Secondary");
        addressCreateDTO.setState("MD");
        addressCreateDTO.setStreet("Street");
        addressCreateDTO.setZip("21654");
        Invoice actualAddAddressToInvoiceResult = invoiceSupportService.addAddressToInvoice(1L, addressCreateDTO);
        assertSame(invoice1, actualAddAddressToInvoiceResult);
        assertEquals("0", actualAddAddressToInvoiceResult.getTotalPrice().toString());
        verify(addressService).addAddress((AddressCreateDTO) any());
        verify(invoiceService).getInvoice((Long) any());
        verify(invoiceRepository).save((Invoice) any());
    }
    /**
     * Method under test: {@link InvoiceSupportService#addAddressToInvoice(Long, Long)}
     */
    @Test
    void testAddAddressToInvoice2() {
        Address address = new Address();
        address.setAddressId(123L);
        address.setCity("Oxford");
        address.setCountry("GB");
        address.setSecondary("Secondary");
        address.setState("MD");
        address.setStreet("Street");
        address.setZip("21654");
        when(addressService.getAddress((Long) any())).thenReturn(address);
        Address address1 = new Address();
        address1.setAddressId(123L);
        address1.setCity("Oxford");
        address1.setCountry("GB");
        address1.setSecondary("Secondary");
        address1.setState("MD");
        address1.setStreet("Street");
        address1.setZip("21654");
        Invoice invoice = new Invoice();
        invoice.setAddress(address1);
        invoice.setCarts(new ArrayList<>());
        invoice.setDateOrdered(LocalDate.ofEpochDay(1L));
        invoice.setInvoiceId(123L);
        invoice.setOrderStatus("Order Status");
        invoice.setTotalPrice(BigDecimal.valueOf(1L));
        invoice.updateTotalPrice();
        when(invoiceService.getInvoice((Long) any())).thenReturn(invoice);
        Address address2 = new Address();
        address2.setAddressId(123L);
        address2.setCity("Oxford");
        address2.setCountry("GB");
        address2.setSecondary("Secondary");
        address2.setState("MD");
        address2.setStreet("Street");
        address2.setZip("21654");
        Invoice invoice1 = new Invoice();
        invoice1.setAddress(address2);
        invoice1.setCarts(new ArrayList<>());
        invoice1.setDateOrdered(LocalDate.ofEpochDay(1L));
        invoice1.setInvoiceId(123L);
        invoice1.setOrderStatus("Order Status");
        invoice1.setTotalPrice(BigDecimal.valueOf(1L));
        invoice1.updateTotalPrice();
        when(invoiceRepository.save((Invoice) any())).thenReturn(invoice1);
        Invoice actualAddAddressToInvoiceResult = invoiceSupportService.addAddressToInvoice(1L, 1L);
        assertSame(invoice1, actualAddAddressToInvoiceResult);
        assertEquals("0", actualAddAddressToInvoiceResult.getTotalPrice().toString());
        verify(addressService).getAddress((Long) any());
        verify(invoiceService).getInvoice((Long) any());
        verify(invoiceRepository).save((Invoice) any());
    }
}

