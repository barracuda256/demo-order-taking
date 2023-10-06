package com.ordertaking.demo.order.dto;

import jakarta.validation.constraints.NotBlank;

public record CustomerDto(@NotBlank String firstName, @NotBlank String lastName) {
}
