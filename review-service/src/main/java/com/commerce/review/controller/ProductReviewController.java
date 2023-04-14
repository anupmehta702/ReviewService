package com.commerce.review.controller;

import com.commerce.review.model.ProductReview;
import com.commerce.review.service.ProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/review")
public class ProductReviewController {

    @Autowired
    ProductReviewService service;

    public ProductReviewController(ProductReviewService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Boolean> addProductReview(@Valid @RequestBody ProductReview productReview) {
        Boolean result = service.addProductReview(productReview);
        return ResponseEntity.ok(result);
    }

    @PutMapping
    public ResponseEntity<Boolean> updateProductReview(@RequestBody ProductReview productReviewToUpdate) {
        Boolean result = service.updateProductReview(productReviewToUpdate);
        return ResponseEntity.ok(result);
    }

    @GetMapping("{productId}")
    public ResponseEntity<ProductReview> getProductReview(@PathVariable String productId) {
        ProductReview productReview = service.getProductReview(productId);
        return ResponseEntity.ok(productReview);
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<Boolean> deleteProductReview(@PathVariable String productId) {
        Boolean result = service.deleteProductReview(productId);
        return ResponseEntity.ok(result);
    }


}
