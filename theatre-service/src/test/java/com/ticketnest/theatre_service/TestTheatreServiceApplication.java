package com.ticketnest.theatre_service;

import org.springframework.boot.SpringApplication;

public class TestTheatreServiceApplication {

    public static void main(String[] args) {
        SpringApplication.from(TheatreServiceApplication::main)
                .with(TestcontainersConfiguration.class)
                .run(args);
    }
}
