package com.ordertaking.demo.order.dto;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static com.ordertaking.demo.order.OrderServiceTestConstants.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomerDtoTest extends AbstractDtoTest {
    @Test
    public void validatorPassesIfCustomerIsValid() {
        CustomerDto customerDto = new CustomerDto(FIRST_NAME, LAST_NAME, EMAIL);
        Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customerDto);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void validatorThrowsExceptionIfFirstNameIsNull() {
        CustomerDto customerDto = new CustomerDto(null, LAST_NAME, EMAIL);
        Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customerDto);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void validatorThrowsExceptionIfFirstNameIsBlank() {
        CustomerDto customerDto = new CustomerDto(BLANK_STRING, LAST_NAME, EMAIL);
        Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customerDto);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void validatorThrowsExceptionIfLastNameIsNull() {
        CustomerDto customerDto = new CustomerDto(FIRST_NAME, null, EMAIL);
        Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customerDto);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void validatorThrowsExceptionIfLastNameIsBlank() {
        CustomerDto customerDto = new CustomerDto(FIRST_NAME, BLANK_STRING, EMAIL);
        Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customerDto);
        assertFalse(violations.isEmpty());
    }

}
