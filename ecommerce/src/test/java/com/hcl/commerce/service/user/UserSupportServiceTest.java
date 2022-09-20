package com.hcl.commerce.service.user;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.hcl.commerce.entity.Address;
import com.hcl.commerce.entity.Invoice;
import com.hcl.commerce.entity.Role;
import com.hcl.commerce.entity.Users;
import com.hcl.commerce.repository.UserRepository;
import com.hcl.commerce.service.address.AddressService;
import com.hcl.commerce.service.invoice.InvoiceService;
import com.hcl.commerce.service.role.RoleService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
@ContextConfiguration(classes = {UserSupportService.class})
@ExtendWith(SpringExtension.class)
class UserSupportServiceTest {
    @MockBean
    private AddressService addressService;
    @MockBean
    private InvoiceService invoiceService;
    @MockBean
    private RoleService roleService;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private UserServiceImplementation userServiceImplementation;
    @Autowired
    private UserSupportService userSupportService;
    /**
     * Method under test: {@link UserSupportService#getAddress(Long)}
     */
    @Test
    void testGetAddress() {
        Users user = new Users();
        HashSet<Address> addressSet = new HashSet<>();
        user.setAddresses(addressSet);
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setInvoices(new ArrayList<>());
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUserId(123L);
        user.setUsername("janedoe");
        when(userServiceImplementation.getUser((Long) any())).thenReturn(user);
        Set<Address> actualAddress = userSupportService.getAddress(1L);
        assertSame(addressSet, actualAddress);
        assertTrue(actualAddress.isEmpty());
        verify(userServiceImplementation).getUser((Long) any());
    }
    /**
     * Method under test: {@link UserSupportService#getInvoices(Long)}
     */
    @Test
    void testGetInvoices() {
        Users user = new Users();
        user.setAddresses(new HashSet<>());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        ArrayList<Invoice> invoiceList = new ArrayList<>();
        user.setInvoices(invoiceList);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUserId(123L);
        user.setUsername("janedoe");
        when(userServiceImplementation.getUser((Long) any())).thenReturn(user);
        List<Invoice> actualInvoices = userSupportService.getInvoices(1L);
        assertSame(invoiceList, actualInvoices);
        assertTrue(actualInvoices.isEmpty());
        verify(userServiceImplementation).getUser((Long) any());
    }
    /**
     * Method under test: {@link UserSupportService#getRoles(Long)}
     */
    @Test
    void testGetRoles() {
        Users user = new Users();
        user.setAddresses(new HashSet<>());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setInvoices(new ArrayList<>());
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        HashSet<Role> roleSet = new HashSet<>();
        user.setRoles(roleSet);
        user.setUserId(123L);
        user.setUsername("janedoe");
        when(userServiceImplementation.getUser((Long) any())).thenReturn(user);
        Set<Role> actualRoles = userSupportService.getRoles(1L);
        assertSame(roleSet, actualRoles);
        assertTrue(actualRoles.isEmpty());
        verify(userServiceImplementation).getUser((Long) any());
    }
    /**
     * Method under test: {@link UserSupportService#addRole(Long, Long)}
     */
    @Test
    void testAddRole() {
        Role role = new Role();
        role.setRoleId(123L);
        role.setRoleName("Role Name");
        when(roleService.getRole((Long) any())).thenReturn(role);
        Users user = new Users();
        user.setAddresses(new HashSet<>());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setInvoices(new ArrayList<>());
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUserId(123L);
        user.setUsername("janedoe");
        when(userRepository.save((Users) any())).thenReturn(user);
        Users user1 = new Users();
        user1.setAddresses(new HashSet<>());
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setInvoices(new ArrayList<>());
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setRoles(new HashSet<>());
        user1.setUserId(123L);
        user1.setUsername("janedoe");
        when(userServiceImplementation.getUser((Long) any())).thenReturn(user1);
        assertSame(user, userSupportService.addRole(1L, 1L));
        verify(roleService).getRole((Long) any());
        verify(userRepository).save((Users) any());
        verify(userServiceImplementation).getUser((Long) any());
    }
    /**
     * Method under test: {@link UserSupportService#addAddress(Long, Long)}
     */
    @Test
    void testAddAddress() {
        Address address = new Address();
        address.setAddressId(123L);
        address.setCity("Oxford");
        address.setCountry("GB");
        address.setSecondary("Secondary");
        address.setState("MD");
        address.setStreet("Street");
        address.setZip("21654");
        when(addressService.getAddress((Long) any())).thenReturn(address);
        Users user = new Users();
        user.setAddresses(new HashSet<>());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setInvoices(new ArrayList<>());
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUserId(123L);
        user.setUsername("janedoe");
        when(userRepository.save((Users) any())).thenReturn(user);
        Users user1 = new Users();
        user1.setAddresses(new HashSet<>());
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setInvoices(new ArrayList<>());
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setRoles(new HashSet<>());
        user1.setUserId(123L);
        user1.setUsername("janedoe");
        when(userServiceImplementation.getUser((Long) any())).thenReturn(user1);
        assertSame(user, userSupportService.addAddress(1L, 1L));
        verify(addressService).getAddress((Long) any());
        verify(userRepository).save((Users) any());
        verify(userServiceImplementation).getUser((Long) any());
    }
    /**
     * Method under test: {@link UserSupportService#addInvoice(Long)}
     */
    @Test
    void testAddInvoice() {
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
        when(invoiceService.addInvoice((Long) any())).thenReturn(invoice);
        Users user = new Users();
        user.setAddresses(new HashSet<>());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setInvoices(new ArrayList<>());
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUserId(123L);
        user.setUsername("janedoe");
        when(userServiceImplementation.getUser((Long) any())).thenReturn(user);
        assertSame(user, userSupportService.addInvoice(1L));
        verify(invoiceService).addInvoice((Long) any());
        verify(userServiceImplementation).getUser((Long) any());
    }
}

