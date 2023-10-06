package com.ordertaking.demo.order.rest.assembler;


import com.ordertaking.demo.order.dto.ProductDto;
import com.ordertaking.demo.order.model.Product;
import com.ordertaking.demo.order.сonverter.ProductModelConverter;
import jakarta.validation.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.ordertaking.demo.order.OrderServiceTestConstants.*;
import static com.ordertaking.demo.order.model.ProductName.*;
import static com.ordertaking.demo.order.model.packages.MobilePackage.*;
import static com.ordertaking.demo.order.model.packages.TelephonyPackage.*;
import static com.ordertaking.demo.order.model.packages.TvPackage.TV_90;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductModelConverterTest {

    private static final String INVALID_PRODUCT = "Invalid product";
    private static final String INVALID_PACKAGE = "Invalid package";

    private ProductModelConverter productModelConverter;

    @BeforeEach
    public void setup() {
        productModelConverter = new ProductModelConverter();
    }

    @Test
    void productDtoAssembledToProduct() {
        ProductDto productDto = new ProductDto(PRODUCT_NAME.toString(), PACKAGE_NAME.toString());
        Product actualProduct = productModelConverter.converter(productDto);
        assertEquals(new Product(PRODUCT_NAME, PACKAGE_NAME), actualProduct);
    }

    @Test
    void productDtoAssembledToTelephony() {
        ProductDto productDto = new ProductDto(TELEPHONY.name(), FREE_ON_NET.toString());
        Product actualProduct = productModelConverter.converter(productDto);
        assertEquals(new Product(TELEPHONY, FREE_ON_NET), actualProduct);
    }

    @Test
    void productDtoAssembledToMobile() {
        ProductDto productDto = new ProductDto(MOBILE.name(), POST_PAID.toString());
        Product actualProduct = productModelConverter.converter(productDto);
        assertEquals(new Product(MOBILE, POST_PAID), actualProduct);
    }

    @Test
    void productDtoAssembledToTv() {
        ProductDto productDto = new ProductDto(TV.toString(), TV_90.toString());
        Product actualProduct = productModelConverter.converter(productDto);
        assertEquals(new Product(TV, TV_90), actualProduct);
    }

    @Test
    void productDtoAssembledThrowsExceptionIfPackageNameIsInvalid() {
        ProductDto productDto = new ProductDto(PRODUCT_NAME.toString(), INVALID_PACKAGE);
        assertThrows(ValidationException.class, () -> productModelConverter.converter(productDto));
    }

    @Test
    void productDtoAssembledThrowsExceptionIfProductNameIsInvalid() {
        ProductDto productDto = new ProductDto(INVALID_PRODUCT, PACKAGE_NAME.toString());
        assertThrows(ValidationException.class, () -> productModelConverter.converter(productDto));
    }

    @Test
    void productDtoAssembledThrowsExceptionIfProductNameIsInvalidForTelephony() {
        ProductDto productDto = new ProductDto(TELEPHONY.name(), INVALID_PACKAGE);
        assertThrows(ValidationException.class, () -> productModelConverter.converter(productDto));
    }

    @Test
    void productDtoAssembledThrowsExceptionIfProductNameIsInvalidForTV() {
        ProductDto productDto = new ProductDto(TV.name(), INVALID_PACKAGE);
        assertThrows(ValidationException.class, () -> productModelConverter.converter(productDto));
    }

    @Test
    void productDtoAssembledThrowsExceptionIfProductNameIsInvalidForMobile() {
        ProductDto productDto = new ProductDto(MOBILE.name(), INVALID_PACKAGE);
        assertThrows(ValidationException.class, () -> productModelConverter.converter(productDto));
    }

}
