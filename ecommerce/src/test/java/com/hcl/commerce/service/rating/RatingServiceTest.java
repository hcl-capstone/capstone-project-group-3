package com.hcl.commerce.service.rating;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.hcl.commerce.dto.rating.RatingCreateDTO;
import com.hcl.commerce.entity.Rating;
import com.hcl.commerce.repository.RatingRepository;
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
}

