package com.ordertaking.demo.order.dto;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static com.ordertaking.demo.order.OrderServiceTestConstants.ADDRESS;
import static com.ordertaking.demo.order.OrderServiceTestConstants.BLANK_STRING;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AddressDtoTest extends AbstractDtoTest {

    @Test
    public void validatorPassesIfAddressIsValid() {
        AddressDto addressDto = new AddressDto(ADDRESS);
        Set<ConstraintViolation<AddressDto>> violations = validator.validate(addressDto);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void validatorThrowsExceptionIfAddressIsBlank() {
        AddressDto addressDto = new AddressDto(BLANK_STRING);
        Set<ConstraintViolation<AddressDto>> violations = validator.validate(addressDto);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void validatorThrowsExceptionIfAddressIsNull() {
        AddressDto addressDto = new AddressDto(null);
        Set<ConstraintViolation<AddressDto>> violations = validator.validate(addressDto);
        assertFalse(violations.isEmpty());
    }

}
