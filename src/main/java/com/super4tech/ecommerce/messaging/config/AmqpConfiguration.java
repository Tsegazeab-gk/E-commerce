package com.super4tech.ecommerce.messaging.config;


import java.util.Arrays;
import java.util.List;

import com.rabbitmq.client.AMQP;
import com.super4tech.ecommerce.messaging.OrderEmailService;
import com.super4tech.ecommerce.messaging.OrderEmailServiceImpl;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.super4tech.ecommerce.messaging")
public class AmqpConfiguration {

/*    <rabbit:connection-factory id="connectionFactory" host="localhost" username="joe" password="joe"/>*/  
	    @Bean
	    public ConnectionFactory connectionFactory() {
	    	CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
	    	connectionFactory.setUsername("guest");
	    	connectionFactory.setPassword("guest");
	    	connectionFactory.setCacheMode(CachingConnectionFactory.CacheMode.CONNECTION);
	        return connectionFactory;
	    }

	@Bean
	public AmqpAdmin amqpAdmin() {
		return new RabbitAdmin(connectionFactory());
	}
	@Bean
	public List<Declarable> orderDirectExchangeBindings() {
		Queue orderStoreQueue = new Queue("orderStoreQueue", true);
		Queue orderOnlineQueue = new Queue("orderOnlineQueue", true);
		DirectExchange orderDirectExchange = new DirectExchange("orderDirectExchange");

		List<Declarable> bindingList = Arrays.<Declarable>asList(
				orderStoreQueue,
				orderOnlineQueue,
				orderDirectExchange,
				BindingBuilder.bind(orderStoreQueue).to(orderDirectExchange).with("order.store"),
				BindingBuilder.bind(orderOnlineQueue).to(orderDirectExchange).with("order.online"));

		return bindingList;
	}


	@Bean
	public RabbitTemplate orderOnlineTemplate() {
		RabbitTemplate orderOnlineTemplate= new RabbitTemplate(connectionFactory());
		orderOnlineTemplate.setRoutingKey("mail.order");
		orderOnlineTemplate.setExchange("orderDirectExchange");
		orderOnlineTemplate.setReplyTimeout(2000);
		return orderOnlineTemplate;
	}

	@Bean
	public OrderEmailService orderEmailService(){
	    	return new OrderEmailServiceImpl();
	}

}
