package com.learn.spring_elastic.DTO;

import lombok.Data;

@Data
public class ProductDTO {

    private String id;
    private String prodName;
    private Double price;
    private Long quantity;

}
