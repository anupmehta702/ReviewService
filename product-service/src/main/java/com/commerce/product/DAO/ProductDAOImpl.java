package com.commerce.product.DAO;

import com.commerce.product.entity.ProductEntity;
import com.commerce.product.exception.ProductNotFoundException;
import com.commerce.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductDAOImpl {
    @Autowired
    ProductRepository repository;

    @Cacheable(value = "productCache", key = "#productId")
    public ProductEntity getProduct(String productId){
        Optional<ProductEntity> product = repository.findById(productId);
        if(product.isPresent()){
            return product.get();
        }else{
            throw new ProductNotFoundException("Product not found !");
        }
    }
}
