package com.hcl.commerce.service.user;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.hcl.commerce.entity.Address;
import com.hcl.commerce.entity.User;
import com.hcl.commerce.repository.UserRepository;
import com.hcl.commerce.service.address.AddressService;
import com.hcl.commerce.service.invoice.InvoiceService;
import com.hcl.commerce.service.role.RoleService;

import java.util.ArrayList;
import java.util.HashSet;

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
        User user = new User();
        user.setAddresses(new HashSet<>());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setInvoices(new ArrayList<>());
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUserId(123L);
        user.setUsername("janedoe");
        when(userRepository.save((User) any())).thenReturn(user);
        User user1 = new User();
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
        verify(userRepository).save((User) any());
        verify(userServiceImplementation).getUser((Long) any());
    }
}

