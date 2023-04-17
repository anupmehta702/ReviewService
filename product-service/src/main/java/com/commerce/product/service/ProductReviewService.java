package com.commerce.product.service;

import com.commerce.product.DAO.ProductDAOImpl;
import com.commerce.product.entity.ProductEntity;
import com.commerce.product.exception.ProductNotFoundException;
import com.commerce.product.exception.ProductReviewNotFoundException;
import com.commerce.product.model.Product;
import com.commerce.product.model.ProductReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductReviewService {

    @Autowired
    ReviewService reviewService;

    @Autowired
    ProductDAOImpl daoImpl;

    public Product getProductReviewDetailsFor(String productId){
        ProductReview review = reviewService.getReview(productId);
        ProductEntity entity = daoImpl.getProduct(productId);
        return getProductFrom(entity,review);
    }

    public Product getProductFrom(ProductEntity entity,ProductReview review){
        return new Product(entity.getProductId(),entity.getProductType(),entity.getName(),review);
    }
}
