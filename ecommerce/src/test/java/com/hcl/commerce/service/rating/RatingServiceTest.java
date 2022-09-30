package com.hcl.commerce.service.rating;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.hcl.commerce.dto.rating.RatingCreateDTO;
import com.hcl.commerce.dto.rating.RatingUpdateDTO;
import com.hcl.commerce.entity.Rating;
import com.hcl.commerce.repository.RatingRepository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
@ContextConfiguration(classes = {RatingService.class})
@ExtendWith(SpringExtension.class)
class RatingServiceTest {
    @MockBean
    private RatingRepository ratingRepository;
    @Autowired
    private RatingService ratingService;
    /**
     * Method under test: {@link RatingService#createRating(RatingCreateDTO)}
     */
    @Test
    void testCreateRating() {
        Rating rating = new Rating();
        rating.setName("Name");
        rating.setRating(1);
        rating.setRatingId(123L);
        rating.setTestimony("Testimony");
        when(ratingRepository.save((Rating) any())).thenReturn(rating);
        RatingCreateDTO ratingCreateDTO = new RatingCreateDTO();
        ratingCreateDTO.setName("Name");
        ratingCreateDTO.setProductId(123L);
        ratingCreateDTO.setRating(1);
        ratingCreateDTO.setTestimony("Testimony");
        assertSame(rating, ratingService.createRating(ratingCreateDTO));
        verify(ratingRepository).save((Rating) any());
    }
    /**
     * Method under test: {@link RatingService#createRating(RatingCreateDTO)}
     */
    @Test
    void testCreateRating2() {
        Rating rating = new Rating();
        rating.setName("Name");
        rating.setRating(1);
        rating.setRatingId(123L);
        rating.setTestimony("Testimony");
        when(ratingRepository.save((Rating) any())).thenReturn(rating);
        RatingCreateDTO ratingCreateDTO = mock(RatingCreateDTO.class);
        when(ratingCreateDTO.getRating()).thenReturn(0);
        when(ratingCreateDTO.getName()).thenReturn("Name");
        when(ratingCreateDTO.getTestimony()).thenReturn("Testimony");
        doNothing().when(ratingCreateDTO).setName((String) any());
        doNothing().when(ratingCreateDTO).setProductId((Long) any());
        doNothing().when(ratingCreateDTO).setRating(anyInt());
        doNothing().when(ratingCreateDTO).setTestimony((String) any());
        ratingCreateDTO.setName("Name");
        ratingCreateDTO.setProductId(123L);
        ratingCreateDTO.setRating(1);
        ratingCreateDTO.setTestimony("Testimony");
        assertSame(rating, ratingService.createRating(ratingCreateDTO));
        verify(ratingRepository).save((Rating) any());
        verify(ratingCreateDTO).getRating();
        verify(ratingCreateDTO).getName();
        verify(ratingCreateDTO).getTestimony();
        verify(ratingCreateDTO).setName((String) any());
        verify(ratingCreateDTO).setProductId((Long) any());
        verify(ratingCreateDTO).setRating(anyInt());
        verify(ratingCreateDTO).setTestimony((String) any());
    }
    /**
     * Method under test: {@link RatingService#getRating(Long)}
     */
    @Test
    void testGetRating() {
        Rating rating = new Rating();
        rating.setName("Name");
        rating.setRating(1);
        rating.setRatingId(123L);
        rating.setTestimony("Testimony");
        Optional<Rating> ofResult = Optional.of(rating);
        when(ratingRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(rating, ratingService.getRating(123L));
        verify(ratingRepository).findById((Long) any());
    }
    /**
     * Method under test: {@link RatingService#getRating(Long)}
     */
    @Test
    void testGetRating2() {
        when(ratingRepository.findById((Long) any())).thenReturn(Optional.empty());
        assertNull(ratingService.getRating(123L));
        verify(ratingRepository).findById((Long) any());
    }
    /**
     * Method under test: {@link RatingService#deleteRating(Long)}
     */
    @Test
    void testDeleteRating() {
        Rating rating = new Rating();
        rating.setName("Name");
        rating.setRating(1);
        rating.setRatingId(123L);
        rating.setTestimony("Testimony");
        Optional<Rating> ofResult = Optional.of(rating);
        doNothing().when(ratingRepository).delete((Rating) any());
        when(ratingRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(rating, ratingService.deleteRating(123L));
        verify(ratingRepository).findById((Long) any());
        verify(ratingRepository).delete((Rating) any());
    }
    /**
     * Method under test: {@link RatingService#deleteRating(Long)}
     */
    @Test
    void testDeleteRating3() {
        doNothing().when(ratingRepository).delete((Rating) any());
        when(ratingRepository.findById((Long) any())).thenReturn(Optional.empty());
        assertNull(ratingService.deleteRating(123L));
        verify(ratingRepository).findById((Long) any());
    }
    /**
     * Method under test: {@link RatingService#updateRating(RatingUpdateDTO)}
     */
    @Test
    void testUpdateRating() {
        Rating rating = new Rating();
        rating.setName("Name");
        rating.setRating(1);
        rating.setRatingId(123L);
        rating.setTestimony("Testimony");
        Optional<Rating> ofResult = Optional.of(rating);
        Rating rating1 = new Rating();
        rating1.setName("Name");
        rating1.setRating(1);
        rating1.setRatingId(123L);
        rating1.setTestimony("Testimony");
        when(ratingRepository.save((Rating) any())).thenReturn(rating1);
        when(ratingRepository.findById((Long) any())).thenReturn(ofResult);
        RatingUpdateDTO ratingUpdateDTO = new RatingUpdateDTO();
        ratingUpdateDTO.setName("Name");
        ratingUpdateDTO.setProductId(123L);
        ratingUpdateDTO.setRating(1);
        ratingUpdateDTO.setRatingId(123L);
        ratingUpdateDTO.setTestimony("Testimony");
        assertSame(rating1, ratingService.updateRating(ratingUpdateDTO));
        verify(ratingRepository).save((Rating) any());
        verify(ratingRepository).findById((Long) any());
    }
    /**
     * Method under test: {@link RatingService#updateRating(RatingUpdateDTO)}
     */
    @Test
    void testUpdateRating3() {
        Rating rating = new Rating();
        rating.setName("Name");
        rating.setRating(1);
        rating.setRatingId(123L);
        rating.setTestimony("Testimony");
        when(ratingRepository.save((Rating) any())).thenReturn(rating);
        when(ratingRepository.findById((Long) any())).thenReturn(Optional.empty());
        RatingUpdateDTO ratingUpdateDTO = new RatingUpdateDTO();
        ratingUpdateDTO.setName("Name");
        ratingUpdateDTO.setProductId(123L);
        ratingUpdateDTO.setRating(1);
        ratingUpdateDTO.setRatingId(123L);
        ratingUpdateDTO.setTestimony("Testimony");
        assertNull(ratingService.updateRating(ratingUpdateDTO));
        verify(ratingRepository).findById((Long) any());
    }
}

