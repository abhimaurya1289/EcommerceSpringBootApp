package com.example.productserviceapplication.controllers;

import com.example.productserviceapplication.models.Product;
import com.example.productserviceapplication.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



/*
Get --> Getting a product
Delete --> Delete a product
Post --> Create a product
Put --> Replacing the complete product (Replace a product completely)

Get product -> modify -> put

Patch --> Updating a product (like name, price, category etc. of a product)
 */


@RestController("/products/{id}")
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    ProductController(ProductService productService){
        this.productService = productService;
    }


    //Ideally it should be Product response DTO
    @GetMapping("/{id}")
    public Product getProductbyId(@PathVariable("id") Long id){
     return productService.getProductById(id);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return new ArrayList<>();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
      return new Product();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return new Product();
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return new Product();
    }

    @DeleteMapping("/{id}")
    public Product deleteProductbyId(@PathVariable("id") Long id){
        return new Product();
    }

}
