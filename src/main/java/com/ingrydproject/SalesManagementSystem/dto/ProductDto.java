package com.ingrydproject.SalesManagementSystem.dto;


import com.ingrydproject.SalesManagementSystem.model.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
public class ProductDto {

    private Long category_id;

    private String name;

    private String description;

    private int price;

    private int stockQuantity;
}
