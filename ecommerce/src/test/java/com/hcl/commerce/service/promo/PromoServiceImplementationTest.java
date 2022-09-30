package com.hcl.commerce.service.promo;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.hcl.commerce.entity.Promo;
import com.hcl.commerce.repository.PromoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
@ContextConfiguration(classes = {PromoServiceImplementation.class})
@ExtendWith(SpringExtension.class)
class PromoServiceImplementationTest {
    @MockBean
    private PromoRepository promoRepository;
    @Autowired
    private PromoServiceImplementation promoServiceImplementation;
    /**
     * Method under test: {@link PromoServiceImplementation#getPromo(String)}
     */
    @Test
    void testGetPromo() {
        Promo promo = new Promo();
        promo.setDiscount(10.0d);
        promo.setPromoCode("Promo Code");
        Optional<Promo> ofResult = Optional.of(promo);
        when(promoRepository.findByPromoCode((String) any())).thenReturn(ofResult);
        assertSame(promo, promoServiceImplementation.getPromo("42"));
        verify(promoRepository).findByPromoCode((String) any());
    }
    /**
     * Method under test: {@link PromoServiceImplementation#getPromo(String)}
     */
    @Test
    void testGetPromo2() {
        when(promoRepository.findByPromoCode((String) any())).thenReturn(Optional.empty());
        assertNull(promoServiceImplementation.getPromo("42"));
        verify(promoRepository).findByPromoCode((String) any());
    }
    /**
     * Method under test: {@link PromoServiceImplementation#getAllPromo()}
     */
    @Test
    void testGetAllPromo() {
        ArrayList<Promo> promoList = new ArrayList<>();
        when(promoRepository.findAll()).thenReturn(promoList);
        List<Promo> actualAllPromo = promoServiceImplementation.getAllPromo();
        assertSame(promoList, actualAllPromo);
        assertTrue(actualAllPromo.isEmpty());
        verify(promoRepository).findAll();
    }
    /**
     * Method under test: {@link PromoServiceImplementation#deletePromo(String)}
     */
    @Test
    void testDeletePromo() {
        Promo promo = new Promo();
        promo.setDiscount(10.0d);
        promo.setPromoCode("Promo Code");
        Optional<Promo> ofResult = Optional.of(promo);
        when(promoRepository.findByPromoCode((String) any())).thenReturn(ofResult);
        doNothing().when(promoRepository).delete((Promo) any());
        assertSame(promo, promoServiceImplementation.deletePromo("42"));
        verify(promoRepository).findByPromoCode((String) any());
        verify(promoRepository).delete((Promo) any());
    }
    /**
     * Method under test: {@link PromoServiceImplementation#deletePromo(String)}
     */
    @Test
    void testDeletePromo2() {
        when(promoRepository.findByPromoCode((String) any())).thenReturn(Optional.empty());
        doNothing().when(promoRepository).delete((Promo) any());
        assertNull(promoServiceImplementation.deletePromo("42"));
        verify(promoRepository).findByPromoCode((String) any());
        verify(promoRepository).delete((Promo) any());
    }
}

