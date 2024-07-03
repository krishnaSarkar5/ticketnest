package com.ticketnest.theatre_service.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class RabbitMQConfig {
    private final AppQueueProperties properties;

    RabbitMQConfig(AppQueueProperties properties) {
        this.properties = properties;
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(properties.getDemoExchange());
    }

    @Bean
    Queue demoOneQueue() {
        return QueueBuilder.durable(properties.getDemoOne()).build();
    }

    @Bean
    Binding demoOneQueueBinding() {
        return BindingBuilder.bind(demoOneQueue()).to(exchange()).with(properties.getDemoOne());
    }

    @Bean
    Queue demoTwoQueue() {
        return QueueBuilder.durable(properties.getDemoTwo()).build();
    }

    @Bean
    Binding demoTwoQueueBinding() {
        return BindingBuilder.bind(demoTwoQueue()).to(exchange()).with(properties.getDemoTwo());
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, ObjectMapper objectMapper) {
        final var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jacksonConverter(objectMapper));
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter jacksonConverter(ObjectMapper mapper) {
        return new Jackson2JsonMessageConverter(mapper);
    }
}
