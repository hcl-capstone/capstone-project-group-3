package com.hcl.commerce.service.user;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.hcl.commerce.dto.address.AddressCreateDTO;
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
        Users users = new Users();
        HashSet<Address> addressSet = new HashSet<>();
        users.setAddress(addressSet);
        users.setEmail("jane.doe@example.org");
        users.setFirstName("Jane");
        users.setIdToken("ABC123");
        users.setInvoices(new ArrayList<>());
        users.setLastName("Doe");
        users.setPassword("iloveyou");
        users.setRoles(new HashSet<>());
        users.setUserId(123L);
        users.setUsername("janedoe");
        when(userServiceImplementation.getUser((Long) any())).thenReturn(users);
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
        Users users = new Users();
        users.setAddress(new HashSet<>());
        users.setEmail("jane.doe@example.org");
        users.setFirstName("Jane");
        users.setIdToken("ABC123");
        ArrayList<Invoice> invoiceList = new ArrayList<>();
        users.setInvoices(invoiceList);
        users.setLastName("Doe");
        users.setPassword("iloveyou");
        users.setRoles(new HashSet<>());
        users.setUserId(123L);
        users.setUsername("janedoe");
        when(userServiceImplementation.getUser((Long) any())).thenReturn(users);
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
        Users users = new Users();
        users.setAddress(new HashSet<>());
        users.setEmail("jane.doe@example.org");
        users.setFirstName("Jane");
        users.setIdToken("ABC123");
        users.setInvoices(new ArrayList<>());
        users.setLastName("Doe");
        users.setPassword("iloveyou");
        HashSet<Role> roleSet = new HashSet<>();
        users.setRoles(roleSet);
        users.setUserId(123L);
        users.setUsername("janedoe");
        when(userServiceImplementation.getUser((Long) any())).thenReturn(users);
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
        Users users = new Users();
        users.setAddress(new HashSet<>());
        users.setEmail("jane.doe@example.org");
        users.setFirstName("Jane");
        users.setIdToken("ABC123");
        users.setInvoices(new ArrayList<>());
        users.setLastName("Doe");
        users.setPassword("iloveyou");
        users.setRoles(new HashSet<>());
        users.setUserId(123L);
        users.setUsername("janedoe");
        when(userRepository.save((Users) any())).thenReturn(users);
        Users users1 = new Users();
        users1.setAddress(new HashSet<>());
        users1.setEmail("jane.doe@example.org");
        users1.setFirstName("Jane");
        users1.setIdToken("ABC123");
        users1.setInvoices(new ArrayList<>());
        users1.setLastName("Doe");
        users1.setPassword("iloveyou");
        users1.setRoles(new HashSet<>());
        users1.setUserId(123L);
        users1.setUsername("janedoe");
        when(userServiceImplementation.getUser((Long) any())).thenReturn(users1);
        assertSame(users, userSupportService.addRole(1L, 1L));
        verify(roleService).getRole((Long) any());
        verify(userRepository).save((Users) any());
        verify(userServiceImplementation).getUser((Long) any());
    }
    /**
     * Method under test: {@link UserSupportService#addAddress(Long, AddressCreateDTO)}
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
        when(addressService.addAddress((AddressCreateDTO) any())).thenReturn(address);
        Users users = new Users();
        users.setAddress(new HashSet<>());
        users.setEmail("jane.doe@example.org");
        users.setFirstName("Jane");
        users.setIdToken("ABC123");
        users.setInvoices(new ArrayList<>());
        users.setLastName("Doe");
        users.setPassword("iloveyou");
        users.setRoles(new HashSet<>());
        users.setUserId(123L);
        users.setUsername("janedoe");
        when(userRepository.save((Users) any())).thenReturn(users);
        Users users1 = new Users();
        users1.setAddress(new HashSet<>());
        users1.setEmail("jane.doe@example.org");
        users1.setFirstName("Jane");
        users1.setIdToken("ABC123");
        users1.setInvoices(new ArrayList<>());
        users1.setLastName("Doe");
        users1.setPassword("iloveyou");
        users1.setRoles(new HashSet<>());
        users1.setUserId(123L);
        users1.setUsername("janedoe");
        when(userServiceImplementation.getUser((Long) any())).thenReturn(users1);
        AddressCreateDTO addressCreateDTO = new AddressCreateDTO();
        addressCreateDTO.setCity("Oxford");
        addressCreateDTO.setCountry("GB");
        addressCreateDTO.setSecondary("Secondary");
        addressCreateDTO.setState("MD");
        addressCreateDTO.setStreet("Street");
        addressCreateDTO.setZip("21654");
        assertSame(users, userSupportService.addAddress(1L, addressCreateDTO));
        verify(addressService).addAddress((AddressCreateDTO) any());
        verify(userRepository).save((Users) any());
        verify(userServiceImplementation).getUser((Long) any());
    }
    /**
     * Method under test: {@link UserSupportService#addAddress(Long, Long)}
     */
    @Test
    void testAddAddress2() {
        Address address = new Address();
        address.setAddressId(123L);
        address.setCity("Oxford");
        address.setCountry("GB");
        address.setSecondary("Secondary");
        address.setState("MD");
        address.setStreet("Street");
        address.setZip("21654");
        when(addressService.getAddress((Long) any())).thenReturn(address);
        Users users = new Users();
        users.setAddress(new HashSet<>());
        users.setEmail("jane.doe@example.org");
        users.setFirstName("Jane");
        users.setIdToken("ABC123");
        users.setInvoices(new ArrayList<>());
        users.setLastName("Doe");
        users.setPassword("iloveyou");
        users.setRoles(new HashSet<>());
        users.setUserId(123L);
        users.setUsername("janedoe");
        when(userRepository.save((Users) any())).thenReturn(users);
        Users users1 = new Users();
        users1.setAddress(new HashSet<>());
        users1.setEmail("jane.doe@example.org");
        users1.setFirstName("Jane");
        users1.setIdToken("ABC123");
        users1.setInvoices(new ArrayList<>());
        users1.setLastName("Doe");
        users1.setPassword("iloveyou");
        users1.setRoles(new HashSet<>());
        users1.setUserId(123L);
        users1.setUsername("janedoe");
        when(userServiceImplementation.getUser((Long) any())).thenReturn(users1);
        assertSame(users, userSupportService.addAddress(1L, 1L));
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
        Users users = new Users();
        users.setAddress(new HashSet<>());
        users.setEmail("jane.doe@example.org");
        users.setFirstName("Jane");
        users.setIdToken("ABC123");
        users.setInvoices(new ArrayList<>());
        users.setLastName("Doe");
        users.setPassword("iloveyou");
        users.setRoles(new HashSet<>());
        users.setUserId(123L);
        users.setUsername("janedoe");
        when(userServiceImplementation.getUser((Long) any())).thenReturn(users);
        assertSame(users, userSupportService.addInvoice(1L));
        verify(invoiceService).addInvoice((Long) any());
        verify(userServiceImplementation).getUser((Long) any());
    }
}

