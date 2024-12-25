package com.example.productcatalogserviceproxy.services;

import com.example.productcatalogserviceproxy.dto.ProductDto;
import com.example.productcatalogserviceproxy.model.Product;

import java.util.List;

public interface IProductService {
    List<Product>  getProducts();

    Product getProduct(Long productId);

    Product createProduct(Product product);

    Product updateProduct(Long id, Product product);
}
