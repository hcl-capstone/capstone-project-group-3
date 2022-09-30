package com.hcl.commerce.service.promo;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.hcl.commerce.entity.Promo;
import com.hcl.commerce.repository.PromoRepository;

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

