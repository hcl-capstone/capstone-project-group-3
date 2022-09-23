package com.hcl.commerce.service.address;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.hcl.commerce.dto.address.AddressCreateDTO;
import com.hcl.commerce.entity.Address;
import com.hcl.commerce.repository.AddressRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
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
    /**
     * Method under test: {@link AddressServiceImplementation#getAddress(Long)}
     */
    @Test
    void testGetAddress() {
        Address address = new Address();
        address.setAddressId(123L);
        address.setCity("Oxford");
        address.setCountry("GB");
        address.setSecondary("Secondary");
        address.setState("MD");
        address.setStreet("Street");
        address.setZip("21654");
        Optional<Address> ofResult = Optional.of(address);
        when(addressRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(address, addressServiceImplementation.getAddress(1L));
        verify(addressRepository).findById((Long) any());
    }
    /**
     * Method under test: {@link AddressServiceImplementation#getAddress(Long)}
     */
    @Test
    void testGetAddress2() {
        when(addressRepository.findById((Long) any())).thenReturn(Optional.empty());
        assertNull(addressServiceImplementation.getAddress(1L));
        verify(addressRepository).findById((Long) any());
    }
    /**
     * Method under test: {@link AddressServiceImplementation#updateAddress(Long, AddressCreateDTO)}
     */
    @Test
    void testUpdateAddress() {
        Address address = new Address();
        address.setAddressId(123L);
        address.setCity("Oxford");
        address.setCountry("GB");
        address.setSecondary("Secondary");
        address.setState("MD");
        address.setStreet("Street");
        address.setZip("21654");
        Optional<Address> ofResult = Optional.of(address);
        Address address1 = new Address();
        address1.setAddressId(123L);
        address1.setCity("Oxford");
        address1.setCountry("GB");
        address1.setSecondary("Secondary");
        address1.setState("MD");
        address1.setStreet("Street");
        address1.setZip("21654");
        when(addressRepository.save((Address) any())).thenReturn(address1);
        when(addressRepository.findById((Long) any())).thenReturn(ofResult);
        AddressCreateDTO addressCreateDTO = new AddressCreateDTO();
        addressCreateDTO.setCity("Oxford");
        addressCreateDTO.setCountry("GB");
        addressCreateDTO.setSecondary("Secondary");
        addressCreateDTO.setState("MD");
        addressCreateDTO.setStreet("Street");
        addressCreateDTO.setZip("21654");
        assertSame(address1, addressServiceImplementation.updateAddress(1L, addressCreateDTO));
        verify(addressRepository).save((Address) any());
        verify(addressRepository).findById((Long) any());
    }
    /**
     * Method under test: {@link AddressServiceImplementation#updateAddress(Long, AddressCreateDTO)}
     */
    @Test
    void testUpdateAddress3() {
        Address address = new Address();
        address.setAddressId(123L);
        address.setCity("Oxford");
        address.setCountry("GB");
        address.setSecondary("Secondary");
        address.setState("MD");
        address.setStreet("Street");
        address.setZip("21654");
        when(addressRepository.save((Address) any())).thenReturn(address);
        when(addressRepository.findById((Long) any())).thenReturn(Optional.empty());
        AddressCreateDTO addressCreateDTO = new AddressCreateDTO();
        addressCreateDTO.setCity("Oxford");
        addressCreateDTO.setCountry("GB");
        addressCreateDTO.setSecondary("Secondary");
        addressCreateDTO.setState("MD");
        addressCreateDTO.setStreet("Street");
        addressCreateDTO.setZip("21654");
        assertNull(addressServiceImplementation.updateAddress(1L, addressCreateDTO));
        verify(addressRepository).findById((Long) any());
    }
    /**
     * Method under test: {@link AddressServiceImplementation#deleteAddress(Long)}
     */
    @Test
    void testDeleteAddress() {
        Address address = new Address();
        address.setAddressId(123L);
        address.setCity("Oxford");
        address.setCountry("GB");
        address.setSecondary("Secondary");
        address.setState("MD");
        address.setStreet("Street");
        address.setZip("21654");
        Optional<Address> ofResult = Optional.of(address);
        doNothing().when(addressRepository).delete((Address) any());
        when(addressRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(address, addressServiceImplementation.deleteAddress(1L));
        verify(addressRepository).findById((Long) any());
        verify(addressRepository).delete((Address) any());
    }
    /**
     * Method under test: {@link AddressServiceImplementation#deleteAddress(Long)}
     */
    @Test
    void testDeleteAddress3() {
        doNothing().when(addressRepository).delete((Address) any());
        when(addressRepository.findById((Long) any())).thenReturn(Optional.empty());
        assertNull(addressServiceImplementation.deleteAddress(1L));
        verify(addressRepository).findById((Long) any());
    }
    /**
     * Method under test: {@link AddressServiceImplementation#getAllAddress()}
     */
    @Test
    void testGetAllAddress() {
        ArrayList<Address> addressList = new ArrayList<>();
        when(addressRepository.findAll()).thenReturn(addressList);
        List<Address> actualAllAddress = addressServiceImplementation.getAllAddress();
        assertSame(addressList, actualAllAddress);
        assertTrue(actualAllAddress.isEmpty());
        verify(addressRepository).findAll();
    }
}

