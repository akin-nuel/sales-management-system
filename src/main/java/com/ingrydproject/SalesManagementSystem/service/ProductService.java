package com.ingrydproject.SalesManagementSystem.service;

import com.ingrydproject.SalesManagementSystem.dto.ProductDto;
import com.ingrydproject.SalesManagementSystem.model.Category;
import com.ingrydproject.SalesManagementSystem.model.Product;
import com.ingrydproject.SalesManagementSystem.repository.CategoryRepository;
import com.ingrydproject.SalesManagementSystem.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Cacheable(value = "product")
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    @CacheEvict(value = "product", allEntries = true)
    public String addProduct(ProductDto productDto){
        Category category = categoryRepository.findCategoryById(productDto.getCategory_id());
        Product product1 = new Product();

        product1.setCategory(category);
        product1.setName(productDto.getName());
        product1.setDescription(productDto.getDescription());
        product1.setPrice(productDto.getPrice());
        product1.setStockQuantity(productDto.getStockQuantity());

        productRepository.save(product1);
        return "Product successfully added";
    }

    @CacheEvict(value = {"product", "id"}, allEntries = true)
    public String updateProduct(Long id, ProductDto productDto){
        Category category = categoryRepository.findCategoryById(productDto.getCategory_id());
        Product update = findProductById(id);

        update.setCategory(category);
        update.setName(productDto.getName());
        update.setDescription(productDto.getDescription());
        update.setPrice(productDto.getPrice());
        update.setStockQuantity(productDto.getStockQuantity());

        productRepository.save(update);
        return "Product successfully updated";
    }

    @CacheEvict(value = {"product", "id"}, allEntries = true)
    public String deleteProduct(Long id){
        productRepository.deleteById(id);
        return "Product successfully deleted";
    }

    public Product findProductById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    public List<Product> findProductByName(String name){
        return productRepository.findProductByName(name);
    }

    public List<Product> findProductByPrice(int price){
        return productRepository.findProductByPrice(price);
    }

}
