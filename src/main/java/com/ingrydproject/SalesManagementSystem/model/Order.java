package com.ingrydproject.SalesManagementSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "date_time")
    LocalDateTime localDateTime = LocalDateTime.now();

    @Column(name = "order_status")
    @NotBlank(message = "Enter the status of the order")
    private String status;

    @NotNull(message = "Enter the amount of the order")
    private int amount;


}
