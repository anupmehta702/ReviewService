package com.commerce.product.controller;

import com.commerce.product.model.Product;
import com.commerce.product.service.ProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductReviewService productReviewService;

    @GetMapping("{productId}")
    public ResponseEntity<Product> getProductReview(@PathVariable String productId) {
        return ResponseEntity.ok(productReviewService.getProductReviewDetailsFor(productId));
    }

}
