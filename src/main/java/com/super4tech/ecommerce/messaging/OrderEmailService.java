package com.super4tech.ecommerce.messaging;

import com.super4tech.ecommerce.domain.Order;
import org.springframework.stereotype.Component;


public interface OrderEmailService {

    public void publish(OrderRequest order) ;
}
