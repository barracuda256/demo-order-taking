package com.ordertaking.demo.order.dto;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static com.ordertaking.demo.order.OrderServiceTestConstants.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductDtoTest extends AbstractDtoTest {

    @Test
    public void validatorPassesIfProductDtoIsValid() {
        ProductDto productDto = new ProductDto(PRODUCT_NAME.toString(), PACKAGE_NAME.toString());
        Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void validatorFailsIfProductNameIsNull() {
        ProductDto productDto = new ProductDto(null, PACKAGE_NAME.toString());
        Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void validatorFailsIfProductNameIsBlank() {
        ProductDto productDto = new ProductDto(BLANK_STRING, PACKAGE_NAME.toString());
        Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void validatorFailsIfPackageNameIsNull() {
        ProductDto productDto = new ProductDto(PRODUCT_NAME.toString(), null);
        Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void validatorFailsIfPackageNameIsBlank() {
        ProductDto productDto = new ProductDto(PRODUCT_NAME.toString(), BLANK_STRING);
        Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);
        assertFalse(violations.isEmpty());
    }

}
