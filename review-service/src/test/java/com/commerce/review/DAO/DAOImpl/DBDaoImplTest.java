package com.commerce.review.DAO.DAOImpl;

import com.commerce.review.entity.ProductReviewEntity;
import com.commerce.review.model.ProductReview;
import com.commerce.review.repository.ProductReviewRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DBDaoImplTest {

    @Mock
    ProductReviewRepository repository;

    @InjectMocks
    DBDaoImpl impl;

    private ProductReviewEntity sampleProductReview = new ProductReviewEntity("ABC1234", 4, 100);

    @Test
    void getProductReview() {
        Mockito.when(repository.findById(Mockito.any())).thenReturn(Optional.of(sampleProductReview));

        ProductReviewEntity response = impl.getProductReview(sampleProductReview.getProductId());

        assertNotNull(response);
        Mockito.verify(repository, Mockito.times(1)).findById(Mockito.any());
    }

    @Test
    void getEmptyProductReview() {
        Mockito.when(repository.findById(Mockito.any())).thenReturn(Optional.ofNullable(null));

        assertThrows(Exception.class, () -> impl.getProductReview(sampleProductReview.getProductId()));

        Mockito.verify(repository, Mockito.times(1)).findById(Mockito.any());
    }

    @Test
    void addProductReview() {
        Mockito.when(repository.save(Mockito.any())).thenReturn(sampleProductReview);
        ProductReview sample = new ProductReview("AB1234", 100, 4);

        assertNotNull(impl.addProductReview(sample));
        Mockito.verify(repository, Mockito.times(1)).save(Mockito.any());

    }


    @Test
    void updateProductReview() {
        Mockito.when(repository.save(Mockito.any())).thenReturn(sampleProductReview);
        ProductReview sample = new ProductReview("AB1234", 100, 4);

        assertNotNull(impl.updateProductReview(sample));
        Mockito.verify(repository, Mockito.times(1)).save(Mockito.any());
    }


    @Test
    void deleteProductReview() {
        Mockito.doNothing().when(repository).deleteById(Mockito.any());

        assertTrue(impl.deleteProductReview(sampleProductReview.getProductId()));
        Mockito.verify(repository, Mockito.times(1)).deleteById(Mockito.any());

    }
}