package com.ordertaking.demo.order;


import com.ordertaking.demo.order.model.ProductName;
import com.ordertaking.demo.order.model.ProductPackage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static com.ordertaking.demo.order.model.packages.InternetPackage.GBPS_1;


public interface OrderServiceTestConstants {
    String REQUEST_ID = "REQUEST_ID";
    String ADDRESS_1 = "16 St John the Baptist street, Sliema";
    String ADDRESS = "20 St John the Baptist street, Sliema";
    String FIRST_NAME = "Artur";
    String LAST_NAME = "Buzov";
    String EMAIL = "demo@gmail.com";
    ProductName PRODUCT_NAME = ProductName.INTERNET;
    ProductPackage PACKAGE_NAME = GBPS_1;
    String BLANK_STRING = "";
    LocalDateTime TIMESLOT_1 = LocalDateTime.of(LocalDate.of(2023, 10, 9), LocalTime.of(9, 0));
    LocalDateTime TIMESLOT_2 = LocalDateTime.of(LocalDate.of(2023, 10, 15), LocalTime.of(9, 0));
}
