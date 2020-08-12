package com.super4tech.ecommerce.messaging;

import java.io.Serializable;

public class OrderRequest implements Serializable {

    private Long id = null;


    private String orderNumber;

    public OrderRequest() {
    }

    public OrderRequest(Long id, String orderNumber) {
        this.id = id;
        this.orderNumber = orderNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
