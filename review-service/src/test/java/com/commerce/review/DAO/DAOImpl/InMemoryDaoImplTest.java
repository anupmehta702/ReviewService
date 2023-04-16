package com.commerce.review.DAO.DAOImpl;

import com.commerce.review.entity.ProductReviewEntity;
import com.commerce.review.model.ProductReview;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryDaoImplTest {

    private InMemoryDaoImpl inMemoryDaoImpl = new InMemoryDaoImpl();
    private ProductReview productToAdd = new ProductReview("AB1234", 4, 100);
    private ProductReviewEntity productEntity = new ProductReviewEntity("AB1234", 4, 100);

    @Test
    void getProductReview() {
        assertNull(inMemoryDaoImpl.getProductReview("XYZ123"));
    }

    @Test
    void getExistingProductReview() {
        assertNotNull(inMemoryDaoImpl.addProductReview(productToAdd));
        assertEquals(productEntity, inMemoryDaoImpl.getProductReview("AB1234"));
    }

    @Test
    void addNewProductReview() {
        assertNotNull(inMemoryDaoImpl.addProductReview(productToAdd));
    }

    @Test
    void updateProductReview() {
        addNewProductReview();
        assertNotNull(inMemoryDaoImpl.updateProductReview(productToAdd));
    }


    @Test
    void deleteProductReview() {
        assertFalse(inMemoryDaoImpl.deleteProductReview("AB1234"));
    }

    @Test
    void deleteExistingProductReview() {
        addNewProductReview();
        assertTrue(inMemoryDaoImpl.deleteProductReview("AB1234"));
        assertNull(inMemoryDaoImpl.getProductReview("AB1234"));
    }
}