package com.example.productcatalogserviceproxy.dto;

import com.example.productcatalogserviceproxy.model.Category;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDTO {
    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    private Category category;
}
