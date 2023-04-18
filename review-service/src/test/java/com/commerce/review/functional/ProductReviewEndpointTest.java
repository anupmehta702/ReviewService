package com.commerce.review.functional;

import com.commerce.review.DAO.ProductReviewDAO;
import com.commerce.review.ReviewApplication;
import com.commerce.review.model.ProductReview;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("IntegrationTest")
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = {ReviewApplication.class})
@Import(ProductReviewEndpointTest.ProductReviewTestContextConfiguration.class)
public class ProductReviewEndpointTest {

    private final String sampleProductId = "AB1234";
    @Autowired
    TestRestTemplate httpRestTemplate;

    @TestConfiguration
    static class ProductReviewTestContextConfiguration {
        @Bean("dbDaoImpl")
        @Primary
        ProductReviewDAO dbDaoImpl() {
            return new TestInMemoryDaoImpl();
        }

        @Bean
        ObjectMapper objectMapper() {
            ObjectMapper om = new ObjectMapper();
            om.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            return om;
        }
    }


    @Test()
    void getReview() {
        addReview();
        ResponseEntity response = httpRestTemplate
                .withBasicAuth("user", "password")
                .getForEntity("/review/" + sampleProductId, ProductReview.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test()
    void addReview() {
        ProductReview productReview = new ProductReview(sampleProductId,100,4);
        ResponseEntity response = httpRestTemplate
                .withBasicAuth("user", "password")
                .postForEntity("/review/",productReview,String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

}
