package com.super4tech.ecommerce.messaging;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = OrderRequest.class)
public class OrderRequest  {

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

    @Override
    public String toString() {
        return "OrderRequest{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                '}';
    }
}
