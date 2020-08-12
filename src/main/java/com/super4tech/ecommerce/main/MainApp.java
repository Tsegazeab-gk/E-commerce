package com.super4tech.ecommerce.main;

import com.super4tech.ecommerce.messaging.config.AmqpConfiguration;
import com.super4tech.ecommerce.service.OrderService;
import com.super4tech.ecommerce.service.impl.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {

//        Customer customer=new Customer("tt","jj","");
//
//        CustomerService service=new CustomerServiceImpl();
//        service.save(customer);


        ApplicationContext context=new AnnotationConfigApplicationContext(AmqpConfiguration.class);

        OrderService orderService=new OrderServiceImpl();
      //  orderService.addOrder()
    }
}
