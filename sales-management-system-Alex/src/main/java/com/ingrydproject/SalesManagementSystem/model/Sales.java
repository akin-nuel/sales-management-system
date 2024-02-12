package com.ingrydproject.SalesManagementSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "sale_Date")
    private Date saleDate;

    @NotNull(message = "Quantity can not be null")
    @NotBlank
    @Min(value = 1)
    private int Quantity;

    @Column(name = "total_price")
    private double totalPrice;

    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;

    public Sales(Date saleDate, int quantity, double totalPrice, User user, Product product) {
        this.saleDate = saleDate;
        Quantity = quantity;
        this.totalPrice = totalPrice;
        this.user = user;
        this.product = product;
    }
}
