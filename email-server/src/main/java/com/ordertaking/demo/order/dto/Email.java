package com.ordertaking.demo.order.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Email(@NotBlank String email,
                    @NotBlank EmailType emailType,
                    @Valid @NotNull OrderDto order) {
}
