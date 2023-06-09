package com.commerce.product.model;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {

    private String productId;
    private String product_type;
    private String name;
    private ProductReview productReview;
    private ExternalProduct externalProduct;

    public Product(String productId, String product_type, String name,ProductReview review, ExternalProduct externalProduct) {
        this.productId = productId;
        this.product_type = product_type;
        this.name = name;
        this.productReview = review;
        this.externalProduct = externalProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productId, product.productId) &&
                Objects.equals(product_type, product.product_type) &&
                Objects.equals(name, product.name) &&
                Objects.equals(productReview, product.productReview) &&
                Objects.equals(externalProduct, product.externalProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, product_type, name, productReview, externalProduct);
    }
}
