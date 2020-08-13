package com.super4tech.ecommerce.messaging;


import com.super4tech.ecommerce.messaging.request.OrderMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderEmailServiceImpl implements OrderEmailService{

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void publish(OrderMessage orderMessage) {


        rabbitTemplate.convertAndSend("purchases.online",orderMessage);

        System.out.println("=============> Order Sent for Email ->"+orderMessage.toString());
    }
}
