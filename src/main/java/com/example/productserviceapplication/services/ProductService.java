package com.example.productserviceapplication.services;

import com.example.productserviceapplication.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    List<Product> getAllProducts();
    Product updateProduct();
    Product replaceProduct();
    Product createProduct();
    Product deleteProduct();



}
