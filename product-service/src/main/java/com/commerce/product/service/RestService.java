package com.commerce.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestService {

    private static final String API_PRODUCTS = "https://www.adidas.co.uk/api/products/";
    @Autowired
    RestTemplate restTemplate;


    public void getProduct(String productId) {

        HttpHeaders headers = new HttpHeaders();

        headers.set("scheme", "https");
        headers.set("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7");
        headers.set("accept-encoding", "gzip, deflate, br");
        headers.set("accept-language", "en-US,en;q=0.9");
        headers.set("cache-control", "max-age=0");

        HttpEntity entity = new HttpEntity(headers);
        String URL = "https://www.adidas.co.uk/api/products/" + productId;
        String URL2 = "https://reqres.in/api/users?page=2";
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                URL2, HttpMethod.GET,
                entity,
                String.class, "");

        System.out.println("status code -->" + responseEntity.getBody());
    }

}
