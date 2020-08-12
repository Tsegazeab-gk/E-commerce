package com.super4tech.ecommerce.messaging.config;


import java.util.Arrays;
import java.util.List;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AmqpConfiguration {

/*    <rabbit:connection-factory id="connectionFactory" host="localhost" username="joe" password="joe"/>*/  
	    @Bean
	    public ConnectionFactory connectionFactory() {
	    	CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
	    	connectionFactory.setUsername("guest");
	    	connectionFactory.setPassword("guest");
	        return connectionFactory;
	    }

	@Bean
	public AmqpAdmin amqpAdmin(ConnectionFactory connectionFactory) {
		return new RabbitAdmin(connectionFactory);
	}

	// Declare Queues, Exchange & Bind all at once...
	@Bean
	public List<Declarable> orderDirectExchangeBindings() {
		Queue orderOnlineQueue = new Queue("orderOnlineQueue", true);
		DirectExchange orderDirectExchange = new DirectExchange("orderDirectExchange");

		List<Declarable> bindingList = Arrays.<Declarable>asList(
				orderOnlineQueue,
				orderDirectExchange,
				BindingBuilder.bind(orderOnlineQueue).to(orderDirectExchange).with("order.online"));

		return bindingList;
	}

	@Bean
	public RabbitTemplate orderOnlineTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate orderOnlineTemplate= new RabbitTemplate(connectionFactory);
		orderOnlineTemplate.setRoutingKey("order.online");
		orderOnlineTemplate.setExchange("orderDirectExchange");
		orderOnlineTemplate.setReplyTimeout(2000);
		return orderOnlineTemplate;
	}


}
