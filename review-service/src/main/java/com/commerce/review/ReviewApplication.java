package com.commerce.review;

import com.commerce.review.DAO.DAOImpl.InMemoryDaoImpl;
import com.commerce.review.DAO.ProductReviewDAO;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class ReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}

	@Bean
	@Qualifier("InMemoryDAOImpl")
	public ProductReviewDAO productReviewDAO(){
		return new InMemoryDaoImpl();
	}

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
		return om;
	}
}
