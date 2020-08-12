package com.super4tech.ecommerce.main;

import com.super4tech.ecommerce.messaging.OrderEmailService;
import com.super4tech.ecommerce.messaging.OrderRequest;
import com.super4tech.ecommerce.messaging.config.AmqpConfiguration;
import com.super4tech.ecommerce.service.OrderService;
import com.super4tech.ecommerce.service.impl.OrderServiceImpl;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {

//        Customer customer=new Customer("tt","jj","");
//
//        CustomerService service=new CustomerServiceImpl();
//        service.save(customer);


        ApplicationContext context=new AnnotationConfigApplicationContext(AmqpConfiguration.class);

       // RabbitTemplate rabbitTemplate=context.getBean("orderOnlineTemplate",RabbitTemplate.class);

        OrderRequest req=new OrderRequest(1L,"Test1");

        OrderEmailService orderEmailService= (OrderEmailService) context.getBean("orderEmailService");

        orderEmailService.publish(req);
        OrderService orderService=new OrderServiceImpl();
      //  orderService.addOrder()
    }
}
