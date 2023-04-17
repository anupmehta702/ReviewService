package com.commerce.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "PRODUCT")
public class ProductEntity implements Serializable {
    @Id
    @Column(name = "product_id")
    private String productId;
    @Column(name = "productType")
    private String productType;
    @Column(name = "name")
    private String name;

    public ProductEntity(){

    }

    public ProductEntity(String productId, String productType, String name) {
        this.productId = productId;
        this.productType = productType;
        this.name = name;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return Objects.equals(productId, that.productId) &&
                Objects.equals(productType, that.productType) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productType, name);
    }
}
