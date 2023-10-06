package com.ordertaking.demo.order.dto;

public enum EmailType {

    NEW_ORDER("new_order");

    String nameTemplate;

    EmailType(String nameTemplate) {
        this.nameTemplate = nameTemplate;
    }

    public String getNameTemplate() {
        return nameTemplate;
    }

}
