package com.super4tech.ecommerce.messaging;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderEmailServiceImpl implements OrderEmailService{

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void publish(OrderRequest order) {


        rabbitTemplate.convertAndSend("purchases.online",order);

        System.out.println("=============> Order Sent for Email ->"+order.toString());
    }
}
