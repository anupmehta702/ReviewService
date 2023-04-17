package com.commerce.product.controller;

import com.commerce.product.model.Product;
import com.commerce.product.model.ProductReview;
import com.commerce.product.service.ProductReviewService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    ProductReviewService productReviewService;

    @InjectMocks
    ProductController controller;

    @Test
    void getProductReview() {
        Product product = new Product("AB1234","cosmetics","default",new ProductReview("AB1234",100,4));
        when(productReviewService.getProductReviewDetailsFor("AB1234")).thenReturn(product);

        ResponseEntity<Product> response = controller.getProductReview("AB1234");
        assertEquals(HttpStatus.OK,response.getStatusCode());
        verify(productReviewService, times(1)).getProductReviewDetailsFor("AB1234");
    }
}