package com.example.productserviceapplication.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakestoreProductDto {
    Long id;
    String title;
    Double price;
    String category;
    String description;
    String image;
}
