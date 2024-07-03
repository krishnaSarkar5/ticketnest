package com.ticketnest.location_service.core.utils;

import com.ticketnest.location_service.core.enums.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static String getCurrentDateByFormat(DateFormat dateFormat) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateFormat.getFormat()));
    }
}
