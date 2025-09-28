package com.learn.spring_elastic.Service;

import com.learn.spring_elastic.DTO.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();

    List<ProductDTO> saveProductsDetail(List<ProductDTO> productDTOs);
}
