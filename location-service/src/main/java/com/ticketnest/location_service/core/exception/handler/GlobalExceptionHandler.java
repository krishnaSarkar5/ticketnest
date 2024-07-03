package com.ticketnest.location_service.core.exception.handler;

import com.ticketnest.location_service.core.dto.ApiResponse;
import com.ticketnest.location_service.core.exception.ResourceNotFoundException;
import com.ticketnest.location_service.core.utils.ResponseUtils;
import jakarta.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Log log = LogFactory.getLog(GlobalExceptionHandler.class);

    private final String SERVICE_NAME = "Location_Service";

    @ExceptionHandler(Exception.class)
    ResponseEntity<ApiResponse> handleUnhandledExceptions(Exception e, HttpRequest httpRequest) {

        String url = httpRequest.getURI().toString();

        Map<String, Object> errorMap = new HashMap<>();
        errorMap.put("message", e.getMessage());
        ResponseEntity<ApiResponse> response = ResponseUtils.failureResponse(SERVICE_NAME, url, errorMap);
        return response;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<ApiResponse> handleResourceNotExceptions(ResourceNotFoundException e) {

        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        // Extract the URL path
        String urlPath = request.getRequestURI();

        log.error("Error ", e);
        Map<String, Object> errorMap = new HashMap<>();
        errorMap.put("message", e.getMessage());
        ResponseEntity<ApiResponse> response = ResponseUtils.failureResponse(SERVICE_NAME, urlPath, errorMap);
        return response;
    }
}
