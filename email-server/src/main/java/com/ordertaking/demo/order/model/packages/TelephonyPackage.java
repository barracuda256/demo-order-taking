package com.ordertaking.demo.order.model.packages;

import com.ordertaking.demo.order.model.ProductPackage;

import java.util.Arrays;
import java.util.Optional;

public enum TelephonyPackage implements ProductPackage {

    FREE_ON_NET("Free On net Calls"),
    UNLIMITED_CALLS("Unlimited Calls");

    private final String id;

    TelephonyPackage(String id) {
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
