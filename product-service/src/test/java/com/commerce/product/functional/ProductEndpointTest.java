package com.commerce.product.functional;

import com.commerce.product.ProductApplication;
import com.commerce.product.configuration.BasicAuthWebSecurityConfiguration;
import com.commerce.product.configuration.RestTemplateConfig;
import com.commerce.product.controller.ProductExceptionHandler;
import com.commerce.product.service.ProductReviewService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ActiveProfiles("IntegrationTest")
@SpringBootTest(properties = { "spring.main.allow-bean-definition-overriding=true" },
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = { ProductApplication.class})
@Import(ProductEndpointTest.ProductReviewTestContextConfiguration.class)
public class ProductEndpointTest {

    @Autowired
    TestRestTemplate httpRestTemplate;

    @TestConfiguration
    static class ProductReviewTestContextConfiguration {
        @Bean
        ProductReviewService productReviewService(){
            ProductReviewService service = new TestProductReviewService();
            return service;
        }
        @Bean
        ObjectMapper objectMapper() {
            ObjectMapper om = new ObjectMapper();
            om.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            return om;
        }
    }


    @Test()
    void acceptOrders() {
        ResponseEntity response = httpRestTemplate
                .withBasicAuth("user", "password")
                .getForEntity("/product/" + "AB1234", String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());


    }

}
