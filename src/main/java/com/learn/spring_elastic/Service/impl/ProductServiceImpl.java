package com.learn.spring_elastic.Service.impl;

import com.learn.spring_elastic.DTO.ProductDTO;
import com.learn.spring_elastic.Entity.Product;
import com.learn.spring_elastic.Repository.ProductRepository;
import com.learn.spring_elastic.Service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDTO> getAllProducts() {
        Iterable<Product> productListIterable = productRepository.findAll();
        List<Product> productList = new ArrayList<>();
        productListIterable.forEach(productList::add);

        List<ProductDTO> productDTOList = productList.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .toList();
        return productDTOList;
    }

    @Override
    public List<ProductDTO> saveProductsDetail(List<ProductDTO> productDTOs) {
        // convert DTO to entities
        List<Product> productList = productDTOs.stream()
                .map(productDto -> modelMapper.map(productDto, Product.class))
                .toList();

        Iterable<Product> savedProducts = productRepository.saveAll(productList);

        // iterable to List
        List<Product> productEntityList = new ArrayList<>();
        savedProducts.forEach(productEntityList::add);

        // convert Entity ro DTOs
        return productEntityList.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .toList();

    }
}
