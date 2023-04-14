package com.commerce.review.service;

import com.commerce.review.DAO.ProductReviewDAO;
import com.commerce.review.exception.ProductAlreadyExistException;
import com.commerce.review.exception.ProductDoesNotExistException;
import com.commerce.review.model.ProductReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductReviewService {

    @Autowired
    private ProductReviewDAO daoImpl;

    public ProductReviewService(ProductReviewDAO daoImpl) {
        this.daoImpl = daoImpl;
    }

    public ProductReview getProductReview(String productId) {
        ProductReview productReview = daoImpl.getProductReview(productId);
        if (productReview == null) {
            throw new ProductDoesNotExistException("Product does not exist !");
        }
        return productReview;
    }

    public boolean addProductReview(ProductReview productReviewToAdd) {
        boolean result = daoImpl.addProductReview(productReviewToAdd);
        if(!result){
            throw new ProductAlreadyExistException("Product already exists !");
        }
        return true;
    }

    public boolean updateProductReview(ProductReview toUpdateProductReview) {
        boolean result = daoImpl.updateProductReview(toUpdateProductReview);
        if(!result){
            throw new ProductDoesNotExistException("Product does not exist !");
        }
        return true;
    }

    public boolean deleteProductReview(String productId) {
        boolean result = daoImpl.deleteProductReview(productId);
        if(!result){
            throw new ProductDoesNotExistException("Product does not exist !");
        }
        return true;

    }
}
