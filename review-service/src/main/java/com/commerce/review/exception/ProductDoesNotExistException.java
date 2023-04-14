package com.commerce.review.exception;

public class ProductDoesNotExistException extends ProductReviewException{
    public ProductDoesNotExistException(String message) {
        super(message);
    }
}
