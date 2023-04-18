package com.commerce.product.service;

import com.commerce.product.model.ProductReview;
import com.commerce.product.exception.ProductReviewNotFoundException;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

@Component
public class ReviewService {

    @Autowired
    @Qualifier("httpRestTemplate")
    RestTemplate httpRestTemplate;

    @Value("${review.api}")
    private String reviewAPI;


    public ProductReview getReview(String productId) {
        try {
            System.out.println("Calling api -->" + reviewAPI);
            httpRestTemplate.getInterceptors().add(new BasicAuthenticationInterceptor("user","password"));

            ResponseEntity<ProductReview> response = httpRestTemplate.getForEntity(reviewAPI+productId,
                     ProductReview.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                return response.getBody();
            } else {
                throw new ProductReviewNotFoundException("No review found for " +
                        "product id -->" + productId + " with response code as -->" + response.getStatusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ProductReviewNotFoundException("No review found for product id -->" + productId);
        }
    }

}
