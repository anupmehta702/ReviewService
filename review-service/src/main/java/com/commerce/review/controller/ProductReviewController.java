package com.commerce.review.controller;

import com.commerce.review.model.ProductReview;
import com.commerce.review.service.ProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/review")
public class ProductReviewController {

    @Value("${app.id}")
    private String appId;


    @Autowired
    ProductReviewService service;

    public ProductReviewController(ProductReviewService service) {
        this.service = service;
    }

    @PostMapping
    public @ResponseBody
    ResponseEntity addProductReview(@Valid @RequestBody ProductReview productReview) {
        System.out.println("Processing the request from instance --> " + appId);
        service.addProductReview(productReview);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public @ResponseBody
    ResponseEntity updateProductReview(@RequestBody ProductReview productReviewToUpdate) {
        service.updateProductReview(productReviewToUpdate);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{productId}")
    public ResponseEntity<ProductReview> getProductReview(@PathVariable String productId) {
        ProductReview productReview = service.getProductReview(productId);
        return ResponseEntity.ok(productReview);
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<Boolean> deleteProductReview(@PathVariable String productId) {
        service.deleteProductReview(productId);
        return ResponseEntity.ok().build();
    }


}
