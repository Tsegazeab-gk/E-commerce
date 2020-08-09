package com.super4tech.ecommerce.controller.response;

import lombok.Data;

@Data
public class AddressResponse {
    private Long id;
    private String street;
    private String city;
    private String state;
    private int zipCode;

    public String getBeautyAddress() {
        return String.format("%s, %s, %s %d", street, city, state, zipCode);
    }
}
