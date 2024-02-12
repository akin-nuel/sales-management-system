package com.ingrydproject.SalesManagementSystem.dto;

import lombok.Getter;


@Getter
public class ProductDto {

    private Long category_id;

    private String name;

    private String description;

    private int price;

    private int stockQuantity;
}
