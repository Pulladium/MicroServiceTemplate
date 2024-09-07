package com.vozh.art.common.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


public record DataItemRequest(
        @NotBlank(message = "Name cannot be blank")
        @Pattern(regexp = "^[a-zA-Z0-9_-]{3,50}$", message = "Name must be 3-50 characters long and contain only letters, numbers, underscores, and hyphens")
        String name,

        @NotBlank(message = "Value cannot be blank")
        String value
) {}