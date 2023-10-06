package com.ordertaking.demo.order.rest.assembler;

import com.ordertaking.demo.order.dto.CustomerDto;
import com.ordertaking.demo.order.model.Customer;
import com.ordertaking.demo.order.сonverter.CustomerModelConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.ordertaking.demo.order.OrderServiceTestConstants.FIRST_NAME;
import static com.ordertaking.demo.order.OrderServiceTestConstants.LAST_NAME;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerModelConverterTest {

    private CustomerModelConverter customerModelConverter;

    @BeforeEach
    public void setup() {
        customerModelConverter = new CustomerModelConverter();
    }

    @Test
    void customerDtoAssembledToCustomer() {
        CustomerDto customerDto = new CustomerDto(FIRST_NAME, LAST_NAME);
        Customer actualCustomer = customerModelConverter.converter(customerDto);
        assertEquals(new Customer(FIRST_NAME, LAST_NAME), actualCustomer);
    }
}
