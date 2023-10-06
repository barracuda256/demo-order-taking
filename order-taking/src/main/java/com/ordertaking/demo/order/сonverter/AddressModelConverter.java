package com.ordertaking.demo.order.сonverter;

import com.ordertaking.demo.order.dto.AddressDto;
import com.ordertaking.demo.order.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressModelConverter implements ModelConverter<AddressDto, Address> {

    @Override
    public Address converter(AddressDto addressDto) {
        return new Address(addressDto.address());
    }
}
