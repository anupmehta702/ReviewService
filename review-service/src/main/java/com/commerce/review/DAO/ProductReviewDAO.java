package com.commerce.review.DAO;

import com.commerce.review.model.ProductReview;

public interface ProductReviewDAO {
    ProductReview getProductReview(String productId);

    boolean addProductReview(ProductReview productReview);

    boolean updateProductReview(ProductReview toUpdateProductReview);

    boolean deleteProductReview(String productId);
}
