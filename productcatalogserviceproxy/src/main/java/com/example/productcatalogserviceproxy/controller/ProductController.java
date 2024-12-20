package com.example.productcatalogserviceproxy.controller;

import com.example.productcatalogserviceproxy.dto.ProductDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping()
    public String getProducts(){
        return "Returning list of all products";
    }

    @GetMapping("{id}")
    public String getProduct(@PathVariable ("id") Long productId){
        return "Returning a product with id "+productId;
    }

    @PostMapping()
    public String createProduct(@RequestBody ProductDTO productDto){
        return "Creating Products... "+productDto;
    }

    @PatchMapping()
    public String updateProduct(@RequestBody ProductDTO productDTO){
        return "updating products " +productDTO;
    }
}
