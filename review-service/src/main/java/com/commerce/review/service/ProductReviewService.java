package com.commerce.review.service;

import com.commerce.review.DAO.ProductReviewDAO;
import com.commerce.review.entity.ProductReviewEntity;
import com.commerce.review.exception.ProductAlreadyExistException;
import com.commerce.review.exception.ProductDoesNotExistException;
import com.commerce.review.model.ProductReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductReviewService {

    @Autowired
    private ProductReviewDAO dbDaoImpl;

    public ProductReviewService(ProductReviewDAO dbDaoImpl) {
        this.dbDaoImpl = dbDaoImpl;
    }

    public ProductReview getProductReview(String productId) {
        try {
            ProductReviewEntity entity = dbDaoImpl.getProductReview(productId);
            return getModelFrom(entity);
        } catch (RuntimeException e) {
            throw new ProductDoesNotExistException("Product does not exist !");
        }

    }

    private ProductReview getModelFrom(ProductReviewEntity e) {
        return new ProductReview(e.getProductId(), e.getAverageReviewScore(), e.getNoOfReviews());
    }

    public boolean addProductReview(ProductReview productReviewToAdd) {
        ProductReviewEntity entity = dbDaoImpl.addProductReview(productReviewToAdd);
        if (entity == null) {
            throw new ProductAlreadyExistException("Product already exists !");
        }
        return true;
    }

    public boolean updateProductReview(ProductReview toUpdateProductReview) {
        ProductReviewEntity entity = dbDaoImpl.updateProductReview(toUpdateProductReview);
        if (entity == null) {
            throw new ProductDoesNotExistException("Product does not exist !");
        }
        return true;
    }

    public boolean deleteProductReview(String productId) {
        boolean result = dbDaoImpl.deleteProductReview(productId);
        if (!result) {
            throw new ProductDoesNotExistException("Product does not exist !");
        }
        return true;

    }
}
