package com.ticketnest.location_service.core.utils;

import com.ticketnest.location_service.core.ResponseStatus;
import com.ticketnest.location_service.core.dto.ApiResponse;
import com.ticketnest.location_service.core.dto.FailureResponse;
import com.ticketnest.location_service.core.dto.SuccessResponse;
import com.ticketnest.location_service.core.enums.DateFormat;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtils {

    public static ResponseEntity<ApiResponse> successResponse(Object data) {

        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setStatus(ResponseStatus.SUCCESS.getStatus());
        successResponse.setStatusCode(200);
        successResponse.setTimeStamp(DateUtils.getCurrentDateByFormat(DateFormat.YYYY_MM_DD_HH_MM_SS));
        successResponse.setData(data);

        ResponseEntity<ApiResponse> response = new ResponseEntity<ApiResponse>(successResponse, HttpStatus.OK);
        return response;
    }

    public static ResponseEntity<ApiResponse> failureResponse(
            String serviceName, String url, Map<String, Object> errorMap) {

        FailureResponse failureResponse = new FailureResponse();
        failureResponse.setStatusCode(400);
        failureResponse.setStatus(ResponseStatus.FAILURE.getStatus());
        failureResponse.setTimeStamp(DateUtils.getCurrentDateByFormat(DateFormat.YYYY_MM_DD_HH_MM_SS));
        failureResponse.setUrl(url);
        failureResponse.setServiceName(serviceName);
        failureResponse.setError(errorMap);

        ResponseEntity<ApiResponse> response = new ResponseEntity<ApiResponse>(failureResponse, HttpStatus.BAD_REQUEST);
        return response;
    }
}
