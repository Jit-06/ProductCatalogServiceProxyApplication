package com.example.productcatalogserviceproxy.model;

import java.util.List;

public class Category extends BaseModel {

    private String name;
    private String description;
    private List<Product> product;

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Product> getProduct() {
        return product;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    // toString Method
    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", product=" + product +
                '}';
    }
}

