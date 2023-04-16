package com.commerce.review.DAO;

import com.commerce.review.entity.ProductReviewEntity;
import com.commerce.review.model.ProductReview;

public interface ProductReviewDAO {
    ProductReviewEntity getProductReview(String productId);

    ProductReviewEntity addProductReview(ProductReview productReview);

    ProductReviewEntity updateProductReview(ProductReview toUpdateProductReview);

    boolean deleteProductReview(String productId);
}
