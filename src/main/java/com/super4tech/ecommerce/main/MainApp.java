package com.super4tech.ecommerce.main;

import com.super4tech.ecommerce.builder.OrderMessageBuilder;
import com.super4tech.ecommerce.enums.CartItemStatus;
import com.super4tech.ecommerce.messaging.OrderEmailService;
import com.super4tech.ecommerce.messaging.OrderRequest;
import com.super4tech.ecommerce.messaging.config.AmqpConfiguration;
import com.super4tech.ecommerce.messaging.request.OrderMessage;
import com.super4tech.ecommerce.service.OrderService;
import com.super4tech.ecommerce.service.impl.OrderServiceImpl;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.util.Date;

public class MainApp {

    public static void main(String[] args) {

//        Customer customer=new Customer("tt","jj","");
//
//        CustomerService service=new CustomerServiceImpl();
//        service.save(customer);


        ApplicationContext context=new AnnotationConfigApplicationContext(AmqpConfiguration.class);
        OrderService orderService=new OrderServiceImpl();

        OrderMessage orderMessage=new OrderMessageBuilder()
                .withId(1L)
                .withBuyerName("Buyer")
                .withBuyerEmail("tsegidey@gmail.com")
                .withBuyerPrice(1500)
               // .withOrderedDate(LocalDateTime.now())
                .withOrderItemMessage(null)
                .withCartItemStatus(CartItemStatus.Created).build();



        OrderEmailService orderEmailService= (OrderEmailService) context.getBean("orderEmailService");

        orderEmailService.publish(orderMessage);


        try {
            Thread.sleep(5000);
        }catch (InterruptedException ie){

        }
      //  orderService.addOrder()
    }
}
