package com.commerce.product.service;

import com.commerce.product.DAO.ProductDAOImpl;
import com.commerce.product.entity.ProductEntity;
import com.commerce.product.exception.ProductNotFoundException;
import com.commerce.product.model.ExternalProduct;
import com.commerce.product.model.ProductReview;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class ProductReviewServiceTest {

    @Mock
    ReviewService reviewService;

    @Mock
    ProductDAOImpl daoImpl;

    @Mock
    ExternalProductRestService externalProductRestService;

    @InjectMocks
    ProductReviewService productReviewService;

    @Test
    void getProductReviewDetailsFor() {
        ProductReview review = new ProductReview("AB1234", 100, 4);
        Mockito.when(reviewService.getReview(any())).thenReturn(review);
        Mockito.when(daoImpl.getProduct(any())).thenReturn(new ProductEntity("AB1234","sports","ABC"));
        Mockito.when(externalProductRestService.getProduct(any())).thenReturn(new ExternalProduct("AB1234","msg","US"));

        assertNotNull(productReviewService.getProductReviewDetailsFor(review.getProductId()));
        Mockito.verify(reviewService, times(1)).getReview(any());
        Mockito.verify(daoImpl, times(1)).getProduct(any());
        Mockito.verify(daoImpl, times(1)).getProduct(any());
    }


}