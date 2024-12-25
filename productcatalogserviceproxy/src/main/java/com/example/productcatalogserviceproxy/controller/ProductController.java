package com.example.productcatalogserviceproxy.controller;

import com.example.productcatalogserviceproxy.dto.ProductDto;
import com.example.productcatalogserviceproxy.model.Category;
import com.example.productcatalogserviceproxy.model.Product;
import com.example.productcatalogserviceproxy.services.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<Product>  getProducts() {
        return productService.getProducts();
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long productId) {
        try {
            if (productId < 1) {
                throw new IllegalArgumentException("Product is not available");
            }
            MultiValueMap<String, String> headers= new LinkedMultiValueMap<>();
            headers.add("CalledBy", "Jitesh");
            Product product= productService.getProduct(productId);
            return new ResponseEntity<>(product, headers, HttpStatus.OK);
        } catch (Exception exception) {
            //return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            throw exception;
        }
    }

    @PostMapping()
    public Product createProduct(@RequestBody ProductDto productDto) {
        Product product= getProduct(productDto);
        return productService.createProduct(product);
    }

    @PatchMapping("{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        Product product=getProduct(productDto);
        return productService.updateProduct(id, product);
    }

    private Product getProduct(ProductDto productDto){
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        Category category = new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);
        product.setId(productDto.getId());
        return product;
    }
}
