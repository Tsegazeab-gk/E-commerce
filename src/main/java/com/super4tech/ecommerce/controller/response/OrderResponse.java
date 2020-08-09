package com.super4tech.ecommerce.controller.response;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
public class OrderResponse {
    private String orderCode;
    private long id;
    private double total;
    private double credit;
    private double points;
    private Date createdDate;
    private String receiver;
    private double earnedPoints;
    private AddressResponse shippingAddress;
    private AddressResponse billingAddress;
    private List<OrderItemResponse> orderItems;
    private String CardNumber;
}
