package com.learn.spring_elastic.Controller;

import com.learn.spring_elastic.DTO.ProductDTO;
import com.learn.spring_elastic.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getAll")
    public List<ProductDTO> getAllProducts(){
        List<ProductDTO> productDTOList = productService.getAllProducts();
        return productDTOList;
    }
}
