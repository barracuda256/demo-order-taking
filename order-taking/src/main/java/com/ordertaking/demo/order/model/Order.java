package com.ordertaking.demo.order.model;

import java.util.List;

public record Order(String requestId,
                    Customer customer,
                    Address address,
                    InstallationDateTime installationDateTime,
                    List<Product> productList) {
}
