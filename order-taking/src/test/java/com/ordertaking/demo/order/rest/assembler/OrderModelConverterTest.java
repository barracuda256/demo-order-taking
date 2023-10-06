package com.ordertaking.demo.order.rest.assembler;

import com.ordertaking.demo.order.dto.*;
import com.ordertaking.demo.order.model.*;
import com.ordertaking.demo.order.сonverter.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static com.ordertaking.demo.order.OrderServiceTestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderModelConverterTest {

    private final AddressDto addressDto = new AddressDto(ADDRESS);
    private final CustomerDto customerDto = new CustomerDto(FIRST_NAME, LAST_NAME);
    private final List<LocalDateTime> timeSlots = List.of(TIMESLOT_1, TIMESLOT_2);
    private final InstallationDateTimeDto installationDateTimeDto = new InstallationDateTimeDto(timeSlots);
    private final ProductDto productDto = new ProductDto(PRODUCT_NAME.toString(), PACKAGE_NAME.toString());
    private OrderModelConverter orderModelConverter;
    private AddressModelConverter addressModelConverter;
    private CustomerModelConverter customerModelConverter;
    private InstallationDateTimeModelConverter installationDateTimeModelConverter;
    private ProductModelConverter productModelConverter;

    @BeforeEach
    public void setup() {
        addressModelConverter = new AddressModelConverter();
        customerModelConverter = new CustomerModelConverter();
        installationDateTimeModelConverter = new InstallationDateTimeModelConverter();
        productModelConverter = new ProductModelConverter();
        orderModelConverter = new OrderModelConverter(addressModelConverter, customerModelConverter, installationDateTimeModelConverter, productModelConverter);
    }

    @Test
    void orderDtoAssembledToOrder() {
        OrderDto orderDto = new OrderDto(customerDto, addressDto, installationDateTimeDto, List.of(productDto));
        Address address = addressModelConverter.converter(addressDto);
        Customer customer = customerModelConverter.converter(customerDto);
        InstallationDateTime installationDateTime = installationDateTimeModelConverter.converter(installationDateTimeDto);
        Product product = productModelConverter.converter(productDto);

        Order actualorder = orderModelConverter.converter(orderDto);
        assertEquals(new Order(customer, address, installationDateTime, List.of(product)), actualorder);
    }
}
