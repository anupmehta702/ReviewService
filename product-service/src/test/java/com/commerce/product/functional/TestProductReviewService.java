package com.commerce.product.functional;

import com.commerce.product.entity.ProductEntity;
import com.commerce.product.model.ExternalProduct;
import com.commerce.product.model.Product;
import com.commerce.product.model.ProductReview;
import com.commerce.product.service.ProductReviewService;

public class TestProductReviewService extends ProductReviewService {

    public Product getProductReviewDetailsFor(String productId) {
        ProductReview review = new ProductReview("AB1234", 100, 4);
        ExternalProduct p = new ExternalProduct("AB1234", "msg", "US");
        return new Product("AB1234", "cosmetics", "shoes", review, p);
    }

}
