package com.ingrydproject.SalesManagementSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "category_name")
    @NotBlank(message = "Enter the name of the category")
    @Length(min = 3)
    private String name;

    @Column(name = "category_description")
    @NotBlank(message = "Describe what the category is about")
    private String description;
}