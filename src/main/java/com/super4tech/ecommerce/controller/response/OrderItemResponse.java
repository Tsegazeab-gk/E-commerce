package com.super4tech.ecommerce.controller.response;


import lombok.Data;

@Data
public class OrderItemResponse {
    private long id;
    private Long productId;
    private String productName;
    private double price;
    private int quantity;
    private String image;

}
