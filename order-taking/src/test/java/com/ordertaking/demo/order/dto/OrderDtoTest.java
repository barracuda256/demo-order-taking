package com.ordertaking.demo.order.dto;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static com.ordertaking.demo.order.OrderServiceTestConstants.*;
import static java.util.Collections.EMPTY_LIST;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OrderDtoTest extends AbstractDtoTest {

    private final AddressDto addressDto = new AddressDto(ADDRESS);
    private final CustomerDto customerDto = new CustomerDto(FIRST_NAME, LAST_NAME);
    private final List<LocalDateTime> timeSlots = List.of(TIMESLOT_1, TIMESLOT_2);
    private final InstallationDateTimeDto installationDateTimeDto = new InstallationDateTimeDto(timeSlots);
    private final ProductDto productDto = new ProductDto(PRODUCT_NAME.toString(), PACKAGE_NAME.toString());

    @Test
    public void validatorPassesIfOrderDtoIsValid() {
        OrderDto orderDto = new OrderDto(customerDto, addressDto, installationDateTimeDto, List.of(productDto));
        Set<ConstraintViolation<OrderDto>> violations = validator.validate(orderDto);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void validatorFailsIfCustomerDtoIsNull() {
        OrderDto orderDto = new OrderDto(null, addressDto, installationDateTimeDto, List.of(productDto));
        Set<ConstraintViolation<OrderDto>> violations = validator.validate(orderDto);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void validatorFailsIfAddressDtoIsNull() {
        OrderDto orderDto = new OrderDto(customerDto, null, installationDateTimeDto, List.of(productDto));
        Set<ConstraintViolation<OrderDto>> violations = validator.validate(orderDto);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void validatorFailsIfInstallationDateTimeDtoIsNull() {
        OrderDto orderDto = new OrderDto(customerDto, addressDto, null, List.of(productDto));
        Set<ConstraintViolation<OrderDto>> violations = validator.validate(orderDto);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void validatorFailsIfProductDtoIsNull() {
        OrderDto orderDto = new OrderDto(customerDto, addressDto, installationDateTimeDto, null);
        Set<ConstraintViolation<OrderDto>> violations = validator.validate(orderDto);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void validatorFailsIfProductListIsEmpty() {
        OrderDto orderDto = new OrderDto(customerDto, addressDto, installationDateTimeDto, EMPTY_LIST);
        Set<ConstraintViolation<OrderDto>> violations = validator.validate(orderDto);
        assertFalse(violations.isEmpty());
    }

}
