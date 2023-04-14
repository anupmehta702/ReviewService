package com.commerce.review.DAO.DAOImpl;

import com.commerce.review.model.ProductReview;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryDaoImplTest {

    private InMemoryDaoImpl inMemoryDaoImpl = new InMemoryDaoImpl();
    private ProductReview productToAdd = new ProductReview("AB1234",4,100);

    @Test
    void getProductReview() {
        assertNull(inMemoryDaoImpl.getProductReview("XYZ123"));
    }

    @Test
    void getExistingProductReview() {
        assertTrue(inMemoryDaoImpl.addProductReview(productToAdd));
        assertEquals(productToAdd,inMemoryDaoImpl.getProductReview("AB1234"));
    }

    @Test
    void addNewProductReview() {
        assertTrue(inMemoryDaoImpl.addProductReview(productToAdd));
    }

    @Test
    void addExistingProductReview() {
        assertTrue(inMemoryDaoImpl.addProductReview(productToAdd));
        assertFalse(inMemoryDaoImpl.addProductReview(productToAdd),"Existing product cannot be added !");

    }

    @Test
    void updateProductReview() {
        assertFalse(inMemoryDaoImpl.updateProductReview(new ProductReview()));
    }

    @Test
    void updateExistingProductReview() {
        addExistingProductReview();
        ProductReview productToUpdate = new ProductReview("AB1234",5,101);
        assertTrue(inMemoryDaoImpl.updateProductReview(productToUpdate));
        assertEquals(inMemoryDaoImpl.getProductReview("AB1234"),productToUpdate);
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