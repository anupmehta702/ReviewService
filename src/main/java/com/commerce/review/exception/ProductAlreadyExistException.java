package com.commerce.review.exception;

public class ProductAlreadyExistException extends ProductReviewException {
    public ProductAlreadyExistException(String message) {
        super(message);
    }
}
