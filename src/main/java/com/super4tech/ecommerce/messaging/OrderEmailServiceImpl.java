package com.super4tech.ecommerce.messaging;


import com.super4tech.ecommerce.messaging.request.OrderMessage;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderEmailServiceImpl implements OrderEmailService{

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void publish(OrderMessage orderMessage) {


        amqpTemplate.convertAndSend("order.detail",orderMessage);

        System.out.println("=============> Order Sent for Email ->"+orderMessage.toString());
    }
}
