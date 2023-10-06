package com.ordertaking.demo.order.сonverter;

public interface ModelConverter<In, Out> {
    Out converter(In in);
}
