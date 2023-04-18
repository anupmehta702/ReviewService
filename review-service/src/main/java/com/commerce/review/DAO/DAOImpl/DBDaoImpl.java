package com.commerce.review.DAO.DAOImpl;

import com.commerce.review.DAO.ProductReviewDAO;
import com.commerce.review.entity.ProductReviewEntity;
import com.commerce.review.model.ProductReview;
import com.commerce.review.repository.ProductReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component("dbDaoImpl")
public class DBDaoImpl implements ProductReviewDAO {

    @Autowired
    private ProductReviewRepository repository;

    @Cacheable(value = "productReviewCache", key = "#productId")
    @Override
    public ProductReviewEntity getProductReview(String productId) {
        return repository.findById(productId).get();
    }

    @CachePut(value = "productReviewCache", key = "#productReview.getProductId()")
    @Override
    public ProductReviewEntity addProductReview(ProductReview productReview) {
        return repository.save(getEntityFrom(productReview));
    }

    @CachePut(value = "productReviewCache", key = "#productReview.getProductId()")
    @Override
    public ProductReviewEntity updateProductReview(ProductReview toUpdateProductReview) {
        return repository.save(getEntityFrom(toUpdateProductReview));
    }

    @CacheEvict(value = "productReviewCache", allEntries = true)
    @Override
    public boolean deleteProductReview(String productId) {
        repository.deleteById(productId);
        return true;
    }

    private ProductReviewEntity getEntityFrom(ProductReview productReview) {
        return new ProductReviewEntity(productReview.getProductId(),
                productReview.getAverageReviewScore(), productReview.getNoOfReviews());
    }

}
