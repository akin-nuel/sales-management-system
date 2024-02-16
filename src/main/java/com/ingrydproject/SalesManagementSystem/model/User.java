package com.ingrydproject.SalesManagementSystem.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "User", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "full_name")
    @NotNull(message = "full name name can not be null")
    @NotBlank(message = "full name can not be blank")
    @Length(min = 6)
    private String fullName;

    @Email(message = "Please enter a valid email address")
    private String email;

    private Role role;

    @Column(name = "phone_number")
    @Length(min = 11, max = 11)
    private String phoneNumber;

    @NotNull(message = "User name name can not be null")
    @NotBlank(message = "User name can not be blank")
    private String address;

    public User(String fullName, String email, Role role, String phoneNumber, String address) {
        this.fullName = fullName;
        this.email = email;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
