package com.commerce.product.model;


import java.io.Serializable;
import java.util.Objects;

public class ExternalProduct implements Serializable {
    private String id;
    private String message;
    private String location;

    public ExternalProduct() {
    }

    public ExternalProduct(String id, String message, String location) {
        this.id = id;
        this.message = message;
        this.location = location;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "ExternalProduct{" +
                "message='" + message + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExternalProduct that = (ExternalProduct) o;
        return Objects.equals(message, that.message) &&
                Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, location);
    }
}
