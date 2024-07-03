package com.ticketnest.location_service.core.enums;

public enum DateFormat {
    YYYY_MM_DD_HH_MM_SS("yyyy-MM-dd HH:mm:ss");

    private String format;

    private DateFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
