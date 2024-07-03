package com.ticketnest.location_service.mapper;

import com.ticketnest.location_service.dto.CountryDto;
import com.ticketnest.location_service.enity.CountryEntity;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper {

    public CountryDto countryEntityToCountryDtoMapper(CountryEntity countryEntity) {
        return CountryDto.builder()
                .code(countryEntity.getCode())
                .name(countryEntity.getName())
                .build();
    }
}
