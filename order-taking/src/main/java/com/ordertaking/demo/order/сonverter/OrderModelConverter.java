package com.ordertaking.demo.order.сonverter;

import com.ordertaking.demo.order.dto.OrderDto;
import com.ordertaking.demo.order.model.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderModelConverter implements ModelConverter<OrderDto, Order> {

    private final AddressModelConverter addressModelAssembler;
    private final CustomerModelConverter customerModelConverter;
    private final InstallationDateTimeModelConverter installationDateTimeModelAssembler;
    private final ProductModelConverter productModelAssembler;

    public OrderModelConverter(AddressModelConverter addressModelAssembler, CustomerModelConverter customerModelConverter, InstallationDateTimeModelConverter installationDateTimeModelAssembler, ProductModelConverter productModelAssembler) {
        this.addressModelAssembler = addressModelAssembler;
        this.customerModelConverter = customerModelConverter;
        this.installationDateTimeModelAssembler = installationDateTimeModelAssembler;
        this.productModelAssembler = productModelAssembler;
    }

    @Override
    public Order converter(OrderDto orderDto) {
        Customer customer = customerModelConverter.converter(orderDto.customer());
        Address address = addressModelAssembler.converter(orderDto.address());
        InstallationDateTime installationDateTime = installationDateTimeModelAssembler.converter(orderDto.installationDateTime());
        List<Product> products = orderDto.productList().stream().map(productModelAssembler::converter).toList();

        return new Order(customer, address, installationDateTime, products);
    }
}
