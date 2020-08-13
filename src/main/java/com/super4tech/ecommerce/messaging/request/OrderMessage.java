package com.super4tech.ecommerce.messaging.request;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.super4tech.ecommerce.enums.CartItemStatus;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope =OrderMessage.class)
public class OrderMessage   {

    private Long id;

    private LocalDateTime orderDate;

    private String  buyerName;

    private String  buyerEmail;

    private double totalPrice;

    private CartItemStatus cartItemStatus ;

    private List<OrderItemMessage> orderItemMessages=new ArrayList<>();

    public OrderMessage() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public CartItemStatus getCartItemStatus() {
        return cartItemStatus;
    }

    public void setCartItemStatus(CartItemStatus cartItemStatus) {
        this.cartItemStatus = cartItemStatus;
    }

    public List<OrderItemMessage> getOrderItemMessages() {
        return orderItemMessages;
    }

    public void setOrderItemMessages(List<OrderItemMessage> orderItemMessages) {
        this.orderItemMessages = orderItemMessages;
    }

    @Override
    public String toString() {
        return "OrderMessage{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", buyerName='" + buyerName + '\'' +
                ", buyerEmail='" + buyerEmail + '\'' +
                ", totalPrice=" + totalPrice +
                ", cartItemStatus=" + cartItemStatus +
                ", orderItemMessages=" + orderItemMessages +
                '}';
    }
}
