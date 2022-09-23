package com.hcl.commerce.service.address;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.hcl.commerce.dto.address.AddressCreateDTO;
import com.hcl.commerce.entity.Address;
import com.hcl.commerce.repository.AddressRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
@ContextConfiguration(classes = {AddressServiceImplementation.class})
@ExtendWith(SpringExtension.class)
class AddressServiceImplementationTest {
    @MockBean
    private AddressRepository addressRepository;
    @Autowired
    private AddressServiceImplementation addressServiceImplementation;
    /**
     * Method under test: {@link AddressServiceImplementation#addAddress(AddressCreateDTO)}
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
        when(addressRepository.save((Address) any())).thenReturn(address);
        AddressCreateDTO addressCreateDTO = new AddressCreateDTO();
        addressCreateDTO.setCity("Oxford");
        addressCreateDTO.setCountry("GB");
        addressCreateDTO.setSecondary("Secondary");
        addressCreateDTO.setState("MD");
        addressCreateDTO.setStreet("Street");
        addressCreateDTO.setZip("21654");
        assertSame(address, addressServiceImplementation.addAddress(addressCreateDTO));
        verify(addressRepository).save((Address) any());
    }
}

