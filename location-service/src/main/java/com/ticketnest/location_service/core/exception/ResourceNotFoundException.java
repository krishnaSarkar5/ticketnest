package com.ticketnest.location_service.core.exception;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException {

    private String message;

    private String resourceName;

    private String code;

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String resourceName, String code) {
        String msg = resourceName + " not found by code " + code;
        this.message = msg;
    }
}
