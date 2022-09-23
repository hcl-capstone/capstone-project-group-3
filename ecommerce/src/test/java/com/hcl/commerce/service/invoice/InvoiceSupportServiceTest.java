package com.hcl.commerce.service.invoice;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.hcl.commerce.dto.address.AddressCreateDTO;
import com.hcl.commerce.entity.Address;
import com.hcl.commerce.entity.Invoice;
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
}

