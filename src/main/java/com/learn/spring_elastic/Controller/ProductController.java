package com.learn.spring_elastic.Controller;

import com.learn.spring_elastic.DTO.ProductDTO;
import com.learn.spring_elastic.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getAll")
    public List<ProductDTO> getAllProducts() {
        List<ProductDTO> productDTOList = productService.getAllProducts();
        return productDTOList;
    }

    @PostMapping("/saveProducts")
    public ResponseEntity<List<ProductDTO>> saveProductDetails(@RequestBody List<ProductDTO> productDTOs) {
        List<ProductDTO> productDTOList = productService.saveProductsDetail(productDTOs);
        return new ResponseEntity<>(productDTOList, HttpStatus.CREATED);
    }
}
