package com.super4tech.ecommerce.controller.response;

import lombok.Data;

import java.util.List;

@Data
public class CheckoutUserResponse {
    private String name;
    private String email;
    private List<AddressResponse> billingAddresses;
    private List<AddressResponse> shippingAddresses;
    private List<CardResponse> cards;
}
