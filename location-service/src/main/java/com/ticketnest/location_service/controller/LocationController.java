package com.ticketnest.location_service.controller;

import com.ticketnest.location_service.core.dto.ApiResponse;
import com.ticketnest.location_service.core.enums.Resource;
import com.ticketnest.location_service.core.exception.ResourceNotFoundException;
import com.ticketnest.location_service.core.utils.ResponseUtils;
import com.ticketnest.location_service.dto.CountryDto;
import com.ticketnest.location_service.service.CountryService;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// controller class

@RestController
@RequestMapping("/api/v1/location")
public class LocationController {

    private CountryService countryService;

    public LocationController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/get-all-countries")
    public ResponseEntity<ApiResponse> getAllCountries() {
        List<CountryDto> allCountries = countryService.getAllCountries();
        return ResponseUtils.successResponse(allCountries);
    }

    @GetMapping("/get-country-by-code")
    public ResponseEntity<ApiResponse> getCountyByCode(@RequestParam("countryCode") String code) {
        Optional<CountryDto> countryDtoOptional = countryService.getCountryByCode(code);
        return countryDtoOptional
                .map(ResponseUtils::successResponse)
                .orElseThrow(() -> new ResourceNotFoundException(Resource.COUNTRY.getName(), code));
    }
}
