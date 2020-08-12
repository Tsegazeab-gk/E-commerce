package com.super4tech.ecommerce.messaging;

import com.super4tech.ecommerce.domain.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderEmailServiceImpl implements OrderEmailService{

    @Autowired
    RabbitTemplate rabbitTemplate;
    @Override
    public void publish(Order order) {
        rabbitTemplate.convertAndSend("order.create",order);
    }
}
