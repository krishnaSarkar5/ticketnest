package com.ticketnest.location_service.core.dto;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FailureResponse extends ApiResponse {

    private String serviceName;

    private String url;

    private Map<String, Object> error;
}
