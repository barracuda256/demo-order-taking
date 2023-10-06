package com.ordertaking.demo.order.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record OrderDto(@Valid @NotNull String requestId,
                       @Valid @NotNull CustomerDto customer,
                       @Valid @NotNull AddressDto address,
                       @Valid @NotNull InstallationDateTimeDto installationDateTime,
                       @Valid @NotEmpty @NotNull List<ProductDto> productList) {

}
