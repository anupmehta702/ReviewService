package com.commerce.review.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "PRODUCT_REVIEW")
public class ProductReviewEntity implements Serializable {

    /*@Id
    private int id;*/
    @Id
    @Column(name = "product_id")
    private String productId;
    @Column(name = "average_review_score")
    private int averageReviewScore;
    @Column(name = "no_of_reviews")
    private int noOfReviews;

    public ProductReviewEntity() {

    }

    public ProductReviewEntity(String productId, int averageReviewScore, int noOfReviews) {
        this.productId = productId;
        this.averageReviewScore = averageReviewScore;
        this.noOfReviews = noOfReviews;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getAverageReviewScore() {
        return averageReviewScore;
    }

    public void setAverageReviewScore(int averageReviewScore) {
        this.averageReviewScore = averageReviewScore;
    }

    public int getNoOfReviews() {
        return noOfReviews;
    }

    public void setNoOfReviews(int noOfReviews) {
        this.noOfReviews = noOfReviews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductReviewEntity entity = (ProductReviewEntity) o;
        return averageReviewScore == entity.averageReviewScore &&
                noOfReviews == entity.noOfReviews &&
                Objects.equals(productId, entity.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, averageReviewScore, noOfReviews);
    }
}
