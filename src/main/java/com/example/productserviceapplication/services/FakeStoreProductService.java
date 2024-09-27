package com.example.productserviceapplication.services;

import com.example.productserviceapplication.dtos.FakestoreProductDto;
import com.example.productserviceapplication.models.Category;
import com.example.productserviceapplication.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(Long id) {
       FakestoreProductDto fakestoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakestoreProductDto.class);
        return convertFakestoreProductToProduct(fakestoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product updateProduct() {
        return null;
    }

    @Override
    public Product replaceProduct() {
        return null;
    }

    @Override
    public Product createProduct() {
        return null;
    }

    @Override
    public Product deleteProduct() {
        return null;
    }

    private Product convertFakestoreProductToProduct(FakestoreProductDto fakestoreProductDto) {
        // Create a new Product object
        Product product = new Product();

        // Set the fields from FakestoreProductDto
        product.setId(fakestoreProductDto.getId());
        product.setTitle(fakestoreProductDto.getTitle());
        product.setPrice(fakestoreProductDto.getPrice());
        product.setDescription(fakestoreProductDto.getDescription());

        // Convert the category (String in FakestoreProductDto) to a Category object
        Category category = new Category();
        category.setTitle(fakestoreProductDto.getCategory());
        // If you need to set the category id, you can do so here, but it might not be available in the DTO
        product.setCategory(category);

        // Return the newly created Product object
        return product;
    }
}
