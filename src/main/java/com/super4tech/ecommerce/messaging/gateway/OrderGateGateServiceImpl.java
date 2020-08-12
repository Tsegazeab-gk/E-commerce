package com.super4tech.ecommerce.messaging.gateway;

import com.super4tech.ecommerce.domain.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderGateGateServiceImpl implements OrderGateService {
 

	// Uses Spring Integration "Gateway" to put message on channel 
	public void publish(OrderGateway orderGateway,Order order) {
        // Create order...

    	orderGateway.process(order);
    	
    }
}
