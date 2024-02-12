package com.ingrydproject.SalesManagementSystem.dto;

import com.ingrydproject.SalesManagementSystem.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String fullName;

    private String email;

    private Role role;

    private String phoneNumber;

    private String address;
}
