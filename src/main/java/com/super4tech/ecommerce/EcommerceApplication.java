package com.super4tech.ecommerce;


import com.super4tech.ecommerce.messaging.OrderEmailService;
import com.super4tech.ecommerce.messaging.config.AmqpConfiguration;
import com.super4tech.ecommerce.service.BuyerService;
import com.super4tech.ecommerce.service.OrderService;
import com.super4tech.ecommerce.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class EcommerceApplication {



    @Autowired
    BuyerService buyerService;

    public static void main(String[] args) {
      //  SpringApplication.run(EcommerceApplication.class, args);

        ConfigurableApplicationContext applicationContext = SpringApplication.run(EcommerceApplication.class, args);
        applicationContext.getBean(EcommerceApplication.class).mainInternal(applicationContext);

    }

    private void mainInternal(ApplicationContext context) {



      //  Customer customer=new Customer("tt","jj","");
//
//        CustomerService service=new CustomerServiceImpl();
      //  customerService.save(customer);

    //    ApplicationContext context=new AnnotationConfigApplicationContext(AmqpConfiguration.class);

        // RabbitTemplate rabbitTemplate=context.getBean("orderOnlineTemplate",RabbitTemplate.class);
//
//        OrderRequest req=new OrderRequest(1L,"Test1");
//
//        OrderEmailService orderEmailService= (OrderEmailService) context.getBean("orderEmailService");
//
//        orderEmailService.publish(req);
//        OrderService orderService=new OrderServiceImpl();
//
//        try {
//            Thread.sleep(5000);
//        }catch (InterruptedException ie){
//
//        }
    }

}
