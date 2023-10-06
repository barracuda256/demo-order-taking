package com.ordertaking.demo.order.rest.converter;

import com.ordertaking.demo.order.dto.AddressDto;
import com.ordertaking.demo.order.model.Address;
import com.ordertaking.demo.order.сonverter.AddressModelConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.ordertaking.demo.order.OrderServiceTestConstants.ADDRESS_1;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AddressModelConverterTest {

    private AddressModelConverter addressModelConverter;

    @BeforeEach
    public void setup() {
        addressModelConverter = new AddressModelConverter();
    }

    @Test
    void addressDtoAssembledToAddress() {
        AddressDto addressDto = new AddressDto(ADDRESS_1);
        Address actualAddress = addressModelConverter.converter(addressDto);
        assertEquals(new Address(ADDRESS_1), actualAddress);
    }
}
