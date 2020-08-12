package com.super4tech.ecommerce.messaging.request;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.math.BigDecimal;

//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = OrderMessage.class)
public class OrderItemMessage {

    private Long id;
    private BigDecimal itemPrice;
    private Long quantity;

    private String productName;

    public OrderItemMessage() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "OrderItemMessage{" +
                "id=" + id +
                ", itemPrice=" + itemPrice +
                ", quantity=" + quantity +
                ", productName='" + productName + '\'' +
                '}';
    }
}
