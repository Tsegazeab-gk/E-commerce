package com.super4tech.ecommerce.aop;


import com.super4tech.ecommerce.builder.OrderItemMessageBuilder;
import com.super4tech.ecommerce.builder.OrderMessageBuilder;
import com.super4tech.ecommerce.domain.Order;
import com.super4tech.ecommerce.messaging.OrderEmailService;
import com.super4tech.ecommerce.messaging.request.OrderItemMessage;
import com.super4tech.ecommerce.messaging.request.OrderMessage;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
public class OrderAspect {


   @Autowired
            OrderEmailService orderEmailService;


    @Pointcut("@annotation(com.super4tech.ecommerce.aop.annotation.OrderNotification)")
    public void placeOrder() {}

    @After("placeOrder() && args(order)")
    public  void sendOrderNotification(JoinPoint jp, Order order){

        OrderItemMessage orderItemMessage=new OrderItemMessageBuilder()
                .withId(order.getCartItem().getCartId())
                .withItemPrice(order.getCartItem().getItem().get(0).getItemPrice())
                .withQuantity(order.getCartItem().getItem().get(0).getQuantity())
                .withProductName(order.getCartItem().getItem().get(0).getProduct().getTitle()).build();
        
        List<OrderItemMessage> itemMessages=new ArrayList<>();
        itemMessages.add(orderItemMessage);


        OrderMessage orderMessage=new OrderMessageBuilder()
                .withId(order.getId())
                .withBuyerName(order.getCartItem().getBuyer().getFirstName())
                .withBuyerEmail(order.getCartItem().getBuyer().getEmail())
                .withBuyerPrice(order.getCartItem().getTotalPrice())
               // .withOrderedDate(order.getOrderDate())
                .withOrderItemMessage(itemMessages)
                .withCartItemStatus(order.getCartItem().getCartItemStatus()).build();

        System.out.println(jp.getSignature().getName());
        System.out.println("------------AOP-------------------------------------------------");
        System.out.println("------------------------------->"+order.toString());
       orderEmailService.publish(orderMessage);

    }

}
