package com.example.authorizationservice.dto;

import java.util.List;

public record AppUserDto(
        String username,
        String password
) {
}
