package com.commerce.review.controller;

import com.commerce.review.model.ProductReview;
import com.commerce.review.service.ProductReviewService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class ProductReviewControllerTest {

    @Mock
    ProductReviewService service;

    @InjectMocks
    ProductReviewController controller;

    ProductReview productReview = new ProductReview("AB1234", 4, 100);

    @Test
    void getProductReview() {
        Mockito.when(service.getProductReview(Mockito.any())).thenReturn(productReview);

        ResponseEntity<ProductReview> response = assertDoesNotThrow(() -> controller.getProductReview(productReview.getProductId()));

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(productReview,response.getBody());
        Mockito.verify(service,Mockito.times(1)).getProductReview(Mockito.any());
    }

    @Test
    void addProductReview() {
        Mockito.when(service.addProductReview(Mockito.any())).thenReturn(true);

        ResponseEntity<Boolean> response = assertDoesNotThrow(() -> controller.addProductReview(productReview));

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(true, response.getBody());
        Mockito.verify(service,Mockito.times(1)).addProductReview(Mockito.any());
    }

    @Test
    void updateProductReview() {
        Mockito.when(service.updateProductReview(Mockito.any())).thenReturn(true);

        ResponseEntity<Boolean> response = assertDoesNotThrow(() -> controller.updateProductReview(productReview));

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(true, response.getBody());
        Mockito.verify(service,Mockito.times(1)).updateProductReview(Mockito.any());
    }

    @Test
    void deleteProductReview() {
        Mockito.when(service.deleteProductReview(Mockito.any())).thenReturn(true);

        ResponseEntity<Boolean> response = assertDoesNotThrow(() -> controller.deleteProductReview(productReview.getProductId()));

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody());
        Mockito.verify(service,Mockito.times(1)).deleteProductReview(Mockito.any());
    }
}