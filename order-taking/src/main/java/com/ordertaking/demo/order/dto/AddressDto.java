package com.ordertaking.demo.order.dto;

import jakarta.validation.constraints.NotBlank;

public record AddressDto(@NotBlank String address) {
}
