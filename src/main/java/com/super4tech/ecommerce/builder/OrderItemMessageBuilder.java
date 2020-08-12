package com.super4tech.ecommerce.builder;

import com.super4tech.ecommerce.messaging.request.OrderItemMessage;
import com.super4tech.ecommerce.messaging.request.OrderMessage;

import java.math.BigDecimal;

public class OrderItemMessageBuilder {

    private OrderItemMessage itemMessage;

    public OrderItemMessageBuilder() {
        itemMessage=new OrderItemMessage();
    }

    public OrderItemMessageBuilder withId(Long id){
        itemMessage.setId(id);
        return this;
    }
    public OrderItemMessageBuilder withItemPrice(BigDecimal price){
        itemMessage.setItemPrice(price);
        return this;
    }
    public OrderItemMessageBuilder withQuantity(Long qt){
        itemMessage.setQuantity(qt);
        return this;
    }

    public OrderItemMessageBuilder withProductName(String name){
        itemMessage.setProductName(name);
        return this;
    }

    public OrderItemMessage build(){
        return itemMessage;
    }

}
