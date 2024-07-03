package com.ticketnest.theatre_service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "queue")
public class AppQueueProperties {
    private String demoExchange;
    private String demoOne;
    private String demoTwo;

    // Getters and setters
    public String getDemoExchange() {
        return demoExchange;
    }

    public void setDemoExchange(String demoExchange) {
        this.demoExchange = demoExchange;
    }

    public String getDemoOne() {
        return demoOne;
    }

    public void setDemoOne(String demoOne) {
        this.demoOne = demoOne;
    }

    public String getDemoTwo() {
        return demoTwo;
    }

    public void setDemoTwo(String demoTwo) {
        this.demoTwo = demoTwo;
    }
}
