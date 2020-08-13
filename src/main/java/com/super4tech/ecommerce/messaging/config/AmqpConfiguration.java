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
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
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
	    	//connectionFactory.setCacheMode(CachingConnectionFactory.CacheMode.CONNECTION);
	        return connectionFactory;
	    }
	@Bean
	public AmqpAdmin amqpAdmin() {
		return new RabbitAdmin(connectionFactory());
	}

	@Bean
	Queue purchasesOnlineQueue() {
		return new Queue("emailOrderDetailQueue", true);
	}



	@Bean
	public Queue purchasesOnlineClassicQueue() {
		return new Queue("purchasesOnlineClassic");
	}

	@Bean
	public  Queue orderQueue(){
	    	return  new Queue("orderInformation",true);
	}

	@Bean
	DirectExchange orderDirectExchange() {
		return new DirectExchange("order-direct-exchange");
	}

	@Bean
	TopicExchange orderExchange() {
		return new TopicExchange("orderDetailExchange");
	}
	@Bean
	List<Binding> bindings() {

		return Arrays.asList(BindingBuilder.bind(purchasesOnlineQueue()).to(orderExchange()).with("purchases.online.#"),
				BindingBuilder.bind(purchasesOnlineClassicQueue()).to(orderExchange()).with("purchases.online.classic.#")
		);
	}

	@Bean
	Binding orderBinding(Queue orderQueue, DirectExchange orderDirectExchange) {
		return BindingBuilder.bind(orderQueue).to(orderDirectExchange).with("order.detail");
	}


	@Bean
	public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate orderOnlineTemplate= new RabbitTemplate(connectionFactory);
	orderOnlineTemplate.setRoutingKey("order.detail");
		orderOnlineTemplate.setExchange("order-direct-exchange");
		 orderOnlineTemplate.setMessageConverter(jsonMessageConverter());
		 orderOnlineTemplate.setReplyTimeout(2000);
		return orderOnlineTemplate;
	}

	@Bean
	public OrderEmailService orderEmailService(){
	    	return new OrderEmailServiceImpl();
	}


	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
}
