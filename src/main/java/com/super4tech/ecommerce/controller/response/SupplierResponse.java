package com.super4tech.ecommerce.controller.response;

import lombok.Data;


@Data
public class SupplierResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
