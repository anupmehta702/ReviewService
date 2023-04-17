package com.commerce.product.DAO;

import com.commerce.product.entity.ProductEntity;
import com.commerce.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ProductDAOImplTest {
    @Mock
    ProductRepository repository;

    @InjectMocks
    ProductDAOImpl daoImpl;

    private ProductEntity sampleEntity = new ProductEntity("AB1234", "sports", "Adidas Shoes");

    @Test
    void getProduct() {
        Mockito.when(repository.findById(Mockito.any())).thenReturn(Optional.of(sampleEntity));

        ProductEntity response = daoImpl.getProduct(sampleEntity.getProductId());

        assertNotNull(response);
        Mockito.verify(repository, Mockito.times(1)).findById(Mockito.any());
    }

    @Test
    void getEmptyProduct() {
        Mockito.when(repository.findById(Mockito.any())).thenReturn(Optional.ofNullable(null));

        assertThrows(Exception.class, () -> daoImpl.getProduct(sampleEntity.getProductId()));

        Mockito.verify(repository, Mockito.times(1)).findById(Mockito.any());
    }
}