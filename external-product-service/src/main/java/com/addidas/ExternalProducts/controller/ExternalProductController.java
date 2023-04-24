package com.addidas.ExternalProducts.controller;

import com.addidas.ExternalProducts.model.ExternalProduct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addidas/api/products/")
public class ExternalProductController {
    @GetMapping("{productId}")
    public ResponseEntity<ExternalProduct> getProductReview(@PathVariable String productId) {
        return ResponseEntity.ok(new ExternalProduct(productId,"New product from Addidas","Pune"));
    }
}
