package com.commerce.product.functional;

import com.commerce.product.ProductApplication;
import com.commerce.product.configuration.BasicAuthWebSecurityConfiguration;
import com.commerce.product.configuration.RestTemplateConfig;
import com.commerce.product.controller.ProductExceptionHandler;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(properties = {"classpath:application-test.yml"},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = {RestTemplateConfig.class, ProductApplication.class, ProductExceptionHandler.class, BasicAuthWebSecurityConfiguration.class})
public class ProductEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Bean
    ObjectMapper objectMapper() {
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        return om;
    }


    //@Test()
    void acceptOrders() {
        ResponseEntity response = testRestTemplate
                .withBasicAuth("user", "password")
                .getForEntity("/product" + "AB1234", Object.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());


    }

}