package com.ordertaking.demo.order.dto;

import jakarta.validation.constraints.NotBlank;

public record ProductDto(@NotBlank String productName, @NotBlank String packageName) {
}
