package com.super4tech.ecommerce;


import com.super4tech.ecommerce.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class EcommerceApplication {



    @Autowired
    BuyerService buyerService;

    public static void main(String[] args) {
      //  SpringApplication.run(EcommerceApplication.class, args);

        ConfigurableApplicationContext applicationContext = SpringApplication.run(EcommerceApplication.class, args);
        applicationContext.getBean(EcommerceApplication.class).mainInternal(applicationContext);

    }

    private void mainInternal(ApplicationContext applicationContext) {



      //  Customer customer=new Customer("tt","jj","");
//
//        CustomerService service=new CustomerServiceImpl();
      //  customerService.save(customer);

    }

}
