package com.hcl.commerce.service.user;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.hcl.commerce.dto.address.AddressCreateDTO;
import com.hcl.commerce.entity.Address;
import com.hcl.commerce.entity.Users;
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
}

