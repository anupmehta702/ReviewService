package com.commerce.product.service;

import com.commerce.product.exception.ProductReviewNotFoundException;
import com.commerce.product.model.ProductReview;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ReviewServiceTest {
    @Mock
    RestTemplate restTemplate;

    @InjectMocks
    ReviewService service;

    String sampleReviewAPI = "localhost:8080/review/";

    @BeforeEach
    public void setup() throws NoSuchFieldException, IllegalAccessException {
        Field field = ReviewService.class.getDeclaredField("reviewAPI");
        field.setAccessible(true);
        field.set(service, sampleReviewAPI);
    }

    @Test
    void getReview() {
        ProductReview review = new ProductReview("AB1234", 100, 4);
        ResponseEntity<ProductReview> response = new ResponseEntity(review, HttpStatus.OK);
        Mockito.when(restTemplate.getForEntity(sampleReviewAPI + review.getProductId(),
                ProductReview.class)).thenReturn(response);

        assertEquals(review, service.getReview("AB1234"));

    }

    @Test
    void getReviewAPIFailure() {
        ProductReview review = new ProductReview("AB1234", 100, 4);
        Mockito.when(restTemplate.getForEntity(sampleReviewAPI + review.getProductId(),
                ProductReview.class)).thenThrow(RestClientException.class);

        assertThrows(ProductReviewNotFoundException.class, () -> service.getReview("AB1234"));
    }

}