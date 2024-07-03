package com.ticketnest.location_service.core;

public enum ResponseStatus {
    SUCCESS("Success"),
    FAILURE("Failure");

    private String status;

    private ResponseStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
