 
  
package com.super4tech.ecommerce.messaging.gateway;

import com.super4tech.ecommerce.domain.Order;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;


@MessagingGateway
public interface OrderGateway {

	@Gateway(requestChannel="toAmqpOrder")
	public void process(Order order);

}
