package com.ingrydproject.SalesManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "product_name")
    @NotBlank(message = "Enter the name of the product")
    @Length(min = 3)
    private String name;

    @Column(name = "product_description")
    @NotBlank(message = "Describe what the product is about")
    private String description;

    @Column(name = "product_price")
    @NotNull(message = "Enter the price of the product")
    private int price;

    @Column(name = "stock_quantity")
    @NotNull( message = "Enter the quantity of the product available")
    private int stockQuantity;

}
