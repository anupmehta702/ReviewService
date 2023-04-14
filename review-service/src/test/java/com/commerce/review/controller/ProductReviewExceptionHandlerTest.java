package com.commerce.review.controller;

import com.commerce.review.exception.ProductReviewException;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ProductReviewExceptionHandlerTest {

    private ProductReviewExceptionHandler exceptionHandler = new ProductReviewExceptionHandler();

    @Test
    void handleProductReviewExceptions() {
        ProductReviewException exp = new ProductReviewException("Not found error !");
        assertDoesNotThrow(() -> exceptionHandler.handleProductReviewExceptions(exp));
    }

    @Test
    void handleValidationExceptions() {
        MethodArgumentNotValidException ex = new MethodArgumentNotValidException(null,
                new BeanPropertyBindingResult(null, null));

        assertDoesNotThrow(() -> exceptionHandler.handleValidationExceptions(ex));
    }
}