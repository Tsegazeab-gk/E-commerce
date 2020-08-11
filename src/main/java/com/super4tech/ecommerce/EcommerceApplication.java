package com.super4tech.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class EcommerceApplication {

    public static void main(String[] args) {

        SpringApplication.run(EcommerceApplication.class, args);

//        ApplicationContext ctx = new ClassPathXmlApplicationContext(
//                "context/applicationContext.xml");

    }

}
