package com.super4tech.ecommerce.controller.request;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class CartRequest {
    private List<CartItemRequest> items = new ArrayList<>();

    @Data
    public static class CartItemRequest {
        private Long id;
        private String name;
        private Integer quantity;
    }
}
