package com.commerce.review.functional;

import com.commerce.review.DAO.ProductReviewDAO;
import com.commerce.review.entity.ProductReviewEntity;
import com.commerce.review.model.ProductReview;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.HashMap;
import java.util.Map;


public class TestInMemoryDaoImpl implements ProductReviewDAO {

    private Map<String, ProductReviewEntity> productReviewMap = new HashMap<>();

    @Override
    public ProductReviewEntity getProductReview(String productId) {
        return productReviewMap.get(productId);
    }

    @Override
    public ProductReviewEntity addProductReview(ProductReview productReview) {
        ProductReviewEntity entity = new ProductReviewEntity(productReview.getProductId(), productReview.getAverageReviewScore(), productReview.getNoOfReviews());
        if (productReviewMap.size() == 0) {
            productReviewMap.put(productReview.getProductId(), entity);
        } else {
            productReviewMap.put(productReview.getProductId(), entity);
        }
        return entity;
    }

    @Override
    public ProductReviewEntity updateProductReview(ProductReview toUpdateProductReview) {
        ProductReviewEntity entity = new ProductReviewEntity(toUpdateProductReview.getProductId(), toUpdateProductReview.getAverageReviewScore(), toUpdateProductReview.getNoOfReviews());
        String productId = toUpdateProductReview.getProductId();
        if (productReviewMap.size() > 0 && productReviewMap.containsKey(productId)) {
            productReviewMap.put(productId, entity);
            return entity;
        }
        System.out.println("Product does not exist for update !");
        return null;
    }

    @Override
    public boolean deleteProductReview(String productId) {
        if (productReviewMap.size() > 0 && productReviewMap.containsKey(productId)) {
            productReviewMap.remove(productId);
            return true;
        }
        return false;
    }
}
