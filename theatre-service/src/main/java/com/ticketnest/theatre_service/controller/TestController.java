package com.ticketnest.theatre_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/theatre/test")
public class TestController {

    @GetMapping
    public String test() {
        return "success";
    }
}
