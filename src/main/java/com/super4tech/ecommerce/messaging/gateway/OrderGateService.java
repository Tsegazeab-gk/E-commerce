package com.super4tech.ecommerce.messaging.gateway;

import com.super4tech.ecommerce.domain.Order;

public interface OrderGateService {
    public void publish(OrderGateway orderGateway, Order order);
}
