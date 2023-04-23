package com.commerce.product.service;

import com.commerce.product.DAO.ProductDAOImpl;
import com.commerce.product.entity.ProductEntity;
import com.commerce.product.model.ExternalProduct;
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

    @Autowired
    ExternalProductRestService externalProductRestService;

    public Product getProductReviewDetailsFor(String productId) {
        ProductReview review = reviewService.getReview(productId);
        ProductEntity entity = daoImpl.getProduct(productId);
        ExternalProduct externalProduct = externalProductRestService.getProduct(productId);
        return getProductFrom(entity, review, externalProduct);
    }

    private Product getProductFrom(ProductEntity entity, ProductReview review, ExternalProduct externalProduct) {
        return new Product(entity.getProductId(), entity.getProductType(), entity.getName(), review, externalProduct);
    }
}
