package com.ticketnest.theatre_service.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    @RabbitListener(queues = "${queue.demo-one}")
    public void handleDemoOne(MessagePublisher.MyPayload myPayload) {
        System.out.println("received from demo one queue : " + myPayload);
    }

    @RabbitListener(queues = "${queue.demo-two}")
    public void handleTwoOne(MessagePublisher.MyPayload myPayload) {
        System.out.println("received from demo two queue : " + myPayload);
    }
}
