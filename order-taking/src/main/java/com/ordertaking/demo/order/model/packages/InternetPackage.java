package com.ordertaking.demo.order.model.packages;


import com.ordertaking.demo.order.model.ProductPackage;

import java.util.Arrays;
import java.util.Optional;

public enum InternetPackage implements ProductPackage {

    MBPS_250("250Mbps"),
    GBPS_1("1Gbps");

    private final String id;

    InternetPackage(String id) {
        this.id = id;
    }

    public static Optional<? extends ProductPackage> getById(String packageName) {
        return Arrays.stream(values()).filter(p -> p.id.equals(packageName)).findFirst();
    }

    @Override
    public String toString() {
        return id;
    }

}
