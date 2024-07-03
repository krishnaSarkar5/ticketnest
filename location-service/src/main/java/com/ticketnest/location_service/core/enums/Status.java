package com.ticketnest.location_service.core.enums;

public enum Status {
    ACTIVE("active");

    private String value;

    private Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
