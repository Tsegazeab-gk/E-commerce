package com.super4tech.ecommerce.aop;


import com.super4tech.ecommerce.builder.OrderMessageBuilder;
import com.super4tech.ecommerce.domain.Order;
import com.super4tech.ecommerce.messaging.OrderEmailService;
import com.super4tech.ecommerce.messaging.gateway.OrderGateService;
import com.super4tech.ecommerce.messaging.gateway.OrderGateway;
import com.super4tech.ecommerce.messaging.request.OrderMessage;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderAspect {

//    @Autowired
//    OrderGateService orderGateService;
//
//    @Autowired
//    OrderGateway orderGateway;

   @Autowired
            OrderEmailService orderEmailService;


    @Pointcut("@annotation(com.super4tech.ecommerce.aop.annotation.OrderNotification)")
    public void placeOrder() {}

    @After("placeOrder() && args(order)")
    public  void sendOrderNotification(JoinPoint jp, Order order){


        OrderMessage orderMessage=new OrderMessageBuilder()
                .withId(order.getId())
                .withBuyerName(order.getCartItem().getBuyer().getFirstName())
                .withBuyerEmail(order.getCartItem().getBuyer().getEmail())
                .withBuyerPrice(order.getCartItem().getTotalPrice())
                .withOrderedDate(order.getOrderDate())
                .withOrderItemMessage(null)
                .withCartItemStatus(order.getCartItem().getCartItemStatus()).build();

        System.out.println(jp.getSignature().getName());
        System.out.println("------------AOP-------------------------------------------------");
        System.out.println("------------------------------->"+order.toString());
       orderEmailService.publish(orderMessage);

    }

}
