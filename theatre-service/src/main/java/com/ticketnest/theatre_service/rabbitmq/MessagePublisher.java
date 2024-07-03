package com.ticketnest.theatre_service.rabbitmq;

import com.ticketnest.theatre_service.config.AppQueueProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagePublisher {

    private final RabbitTemplate rabbitTemplate;

    private final AppQueueProperties properties;

    public MessagePublisher(RabbitTemplate rabbitTemplate, AppQueueProperties properties) {
        this.rabbitTemplate = rabbitTemplate;
        this.properties = properties;
    }

    @PostMapping("/send")
    public void sendMessage(@RequestBody MyMessage myMessage) {
        rabbitTemplate.convertAndSend(properties.getDemoExchange(), myMessage.routingKey, myMessage.payload);
    }

    record MyMessage(String routingKey, MyPayload payload) {}

    record MyPayload(String content) {}
}
