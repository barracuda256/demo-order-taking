package com.ordertaking.demo.order.сonverter;

import com.ordertaking.demo.order.dto.CustomerDto;
import com.ordertaking.demo.order.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerModelConverter implements ModelConverter<CustomerDto, Customer> {

    @Override
    public Customer converter(CustomerDto customerDto) {
        return new Customer(
            customerDto.firstName(),
            customerDto.lastName(),
            customerDto.email()
        );
    }
}
