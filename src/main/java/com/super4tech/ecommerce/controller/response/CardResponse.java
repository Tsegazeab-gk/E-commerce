package com.super4tech.ecommerce.controller.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CardResponse {
    private Long id;
    private String name;
    private String cardNumber;
    private LocalDate valid;
}
