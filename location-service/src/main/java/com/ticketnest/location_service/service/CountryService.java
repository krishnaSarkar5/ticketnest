package com.ticketnest.location_service.service;

import com.ticketnest.location_service.dto.CountryDto;
import java.util.List;
import java.util.Optional;

public interface CountryService {

    public List<CountryDto> getAllCountries();

    public Optional<CountryDto> getCountryByCode(String code);
}
