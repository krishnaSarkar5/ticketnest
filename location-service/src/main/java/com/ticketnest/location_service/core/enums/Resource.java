package com.ticketnest.location_service.core.enums;

public enum Resource {
    COUNTRY("Country");

    private String name;

    private Resource(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
