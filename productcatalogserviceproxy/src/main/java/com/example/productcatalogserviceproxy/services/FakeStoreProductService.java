package com.example.productcatalogserviceproxy.services;


import com.example.productcatalogserviceproxy.clients.fakestore.clients.FakeStoreAPIClient;
import com.example.productcatalogserviceproxy.clients.fakestore.dtos.FakeStoreProductDto;
import com.example.productcatalogserviceproxy.model.Category;
import com.example.productcatalogserviceproxy.model.Product;
import org.apache.coyote.Response;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements IProductService {

    private RestTemplateBuilder restTemplateBuilder;
    private FakeStoreAPIClient fakeStoreAPIClient;

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder, FakeStoreAPIClient fakeStoreAPIClient) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreAPIClient = fakeStoreAPIClient;
    }

    @Override

    public List<Product> getProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreProductDto[].class).getBody();
        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto productDto : fakeStoreProductDtos) {
            products.add(getProduct(productDto));
        }
        return products;

    }


    @Override
    public Product getProduct(Long productId) {
        return getProduct(fakeStoreAPIClient.getProduct(productId));
    }

    @Override
    public Product createProduct(Product product) {
       // RestTemplate restTemplate = restTemplateBuilder.build();
        //ResponseEntity<FakeStoreProductDto> fakeStoreproductDtoResponseEntity = restTemplate.postForEntity("https://fakestoreapi.com/products", product, FakeStoreProductDto.class);
        FakeStoreProductDto fakeStoreProductDto = getFakeStoreProductDto(product);
        FakeStoreProductDto responseFakeStoreProductDto = fakeStoreAPIClient.createProduct(fakeStoreProductDto);
        return getProduct(responseFakeStoreProductDto);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        //FakeStoreProductDto fakeStoreProductDto = restTemplate.patchForObject("https://fakestoreapi.com/products/{id}", product, FakeStoreProductDto.class, id);
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = requestForEntity(HttpMethod.PATCH, "https://fakestoreapi.com/products/{id}", product, FakeStoreProductDto.class, id);
        Product resultantProduct = getProduct(fakeStoreProductDtoResponseEntity.getBody());
        return resultantProduct;
    }


    private <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }

    private Product getProduct(FakeStoreProductDto productDTO) {
        Product product = new Product();
        product.setTitle(productDTO.getTitle());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        Category category = new Category();
        category.setName(productDTO.getCategory());
        product.setCategory(category);
        product.setId(productDTO.getId());
        return product;
    }

    private FakeStoreProductDto getFakeStoreProductDto(Product product) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setCategory(product.getCategory().getDescription());
        fakeStoreProductDto.setImage(product.getImageUrl());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setPrice(product.getPrice());
        return fakeStoreProductDto;

    }

}
