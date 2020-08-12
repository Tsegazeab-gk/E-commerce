package com.super4tech.ecommerce.builder;

import com.super4tech.ecommerce.enums.CartItemStatus;
import com.super4tech.ecommerce.messaging.request.OrderItemMessage;
import com.super4tech.ecommerce.messaging.request.OrderMessage;

import java.time.LocalDateTime;
import java.util.List;

public class OrderMessageBuilder {

    private OrderMessage orderMessage;

    public OrderMessageBuilder() {
        this.orderMessage = new OrderMessage();
    }

    public OrderMessageBuilder withId(Long id){
        orderMessage.setId(id);
        return this;
    }
    public OrderMessageBuilder withBuyerName(String name){
        orderMessage.setBuyerName(name);
        return this;
    }

    public OrderMessageBuilder withBuyerEmail(String email){
        orderMessage.setBuyerEmail(email);
        return this;
    }
    public OrderMessageBuilder withBuyerPrice(double price){
        orderMessage.setTotalPrice(price);
        return this;
    }
    public OrderMessageBuilder withOrderedDate(LocalDateTime d){
        orderMessage.setOrderDate(d);
        return this;
    }
    public OrderMessageBuilder withCartItemStatus(CartItemStatus s){
        orderMessage.setCartItemStatus(s);
        return this;
    }

    public OrderMessageBuilder withOrderItemMessage(List<OrderItemMessage> orderItemMessage){
        orderMessage.setOrderItemMessages(orderItemMessage);
        return this;
    }

    public OrderMessage build(){
        return orderMessage;
    }

}
