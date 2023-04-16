package com.commerce.review.repository;

import com.commerce.review.entity.ProductReviewEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReviewRepository extends CrudRepository<ProductReviewEntity,String> {
}
