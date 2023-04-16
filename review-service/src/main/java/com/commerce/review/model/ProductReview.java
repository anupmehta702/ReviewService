package com.commerce.review.model;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class ProductReview {
    @NotNull(message = "ProductId cannot be null!")
    private String productId;
    private int averageReviewScore;
    private int noOfReviews;

    public ProductReview() {

    }

    public ProductReview(String productId, int averageReviewScore, int noOfReviews) {
        this.productId = productId;
        this.averageReviewScore = averageReviewScore;
        this.noOfReviews = noOfReviews;
    }

    public String getProductId() {
        return productId;
    }

    public int getAverageReviewScore() {
        return averageReviewScore;
    }

    public int getNoOfReviews() {
        return noOfReviews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductReview that = (ProductReview) o;
        return averageReviewScore == that.averageReviewScore &&
                noOfReviews == that.noOfReviews &&
                Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, averageReviewScore, noOfReviews);
    }


}
