package com.example.brand_new_axis.entities.dtos;

import com.example.brand_new_axis.entities.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {

}
