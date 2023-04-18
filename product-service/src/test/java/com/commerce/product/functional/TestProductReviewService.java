package com.commerce.product.functional;

import com.commerce.product.model.Product;
import com.commerce.product.service.ProductReviewService;

public class TestProductReviewService extends ProductReviewService {

    public Product getProductReviewDetailsFor(String productId){
        return new Product("AB1234","cosmetics","shoes",null);
    }

}
