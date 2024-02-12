package com.ingrydproject.SalesManagementSystem.controller;


import com.ingrydproject.SalesManagementSystem.dto.ProductDto;
import com.ingrydproject.SalesManagementSystem.model.Product;
import com.ingrydproject.SalesManagementSystem.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProduct(){
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }

    @PostMapping("/product")
    public String addProduct(@Valid @RequestBody ProductDto productDto){
        return productService.addProduct(productDto);
    }

    @PutMapping("/product/{id}")
    public String updateProduct(@PathVariable Long id, @Valid @RequestBody ProductDto productDto){
        return productService.updateProduct(id, productDto);
    }

    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);
    }

    @GetMapping("/product/id/{id}")
    @ResponseBody
    public Product findProductById(Long id){
        return productService.findProductById(id);
    }

    @GetMapping("/product/name/{name}")
    @ResponseBody
    public List<Product> findProductByName(String name){
        return productService.findProductByName(name);
    }

    @GetMapping("/product/price/{price}")
    @ResponseBody
    public List<Product> findProductByPrice(int price){
        return productService.findProductByPrice(price);
    }
}
