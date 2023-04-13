package com.commerce.review.service;

import com.commerce.review.DAO.ProductReviewDAO;
import com.commerce.review.exception.ProductAlreadyExistException;
import com.commerce.review.exception.ProductDoesNotExistException;
import com.commerce.review.model.ProductReview;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    ProductReviewDAO dao;

    @InjectMocks
    private ProductService service;

    private ProductReview productReview = new ProductReview("AB1234", 4, 100);

    @Test
    void getProductReview() {
        Mockito.when(dao.getProductReview("AB1234")).thenReturn(productReview);
        assertEquals(productReview, service.getProductReview("AB1234"));
    }

    @Test
    void getNonExistingProductReview(){
        Mockito.when(dao.getProductReview("AB12345")).thenReturn(null);
        assertThrows(ProductDoesNotExistException.class,()->service.getProductReview("AB12345"));
    }

    @Test
    void addProductReview(){
        Mockito.when(dao.addProductReview(productReview)).thenReturn(true);
        assertTrue(service.addProductReview(productReview));
    }

    @Test
    void addExistingProductReview(){
        Mockito.when(dao.addProductReview(productReview)).thenReturn(false);
        assertThrows(ProductAlreadyExistException.class,()->service.addProductReview(productReview));
    }

    @Test
    void updateProductReview(){
        Mockito.when(dao.updateProductReview(productReview)).thenReturn(true);
        assertTrue(service.updateProductReview(productReview));
    }

    @Test
    void updateExistingProductReview(){
        Mockito.when(dao.updateProductReview(productReview)).thenReturn(false);
        assertThrows(ProductDoesNotExistException.class,()->service.updateProductReview(productReview));
    }

    @Test
    void deleteProductReview(){
        Mockito.when(dao.deleteProductReview("AB1234")).thenReturn(true);
        assertTrue(service.deleteProductReview("AB1234"));
    }

    @Test
    void deleteExistingProductReview(){
        Mockito.when(dao.deleteProductReview("ABCD1234")).thenReturn(false);
        assertThrows(ProductDoesNotExistException.class,()->service.deleteProductReview("ABCD1234"));
    }
}