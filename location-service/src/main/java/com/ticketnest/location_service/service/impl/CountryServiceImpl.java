package com.ticketnest.location_service.service.impl;

import com.ticketnest.location_service.core.enums.Status;
import com.ticketnest.location_service.dao.CountryDao;
import com.ticketnest.location_service.dto.CountryDto;
import com.ticketnest.location_service.enity.CountryEntity;
import com.ticketnest.location_service.mapper.CountryMapper;
import com.ticketnest.location_service.service.CountryService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    private CountryDao countryDao;

    private CountryMapper countryMapper;

    public CountryServiceImpl(CountryDao countryDao, CountryMapper countryMapper) {
        this.countryDao = countryDao;
        this.countryMapper = countryMapper;
    }

    @Override
    public List<CountryDto> getAllCountries() {

        List<CountryEntity> allCountryByStatus = countryDao.getAllCountryByStatus(Status.ACTIVE.getValue());

        List<CountryDto> countryDtoList = allCountryByStatus.stream()
                .map(countryEntity -> countryMapper.countryEntityToCountryDtoMapper(countryEntity))
                .collect(Collectors.toList());

        return countryDtoList;
    }

    @Override
    public Optional<CountryDto> getCountryByCode(String code) {

        Optional<CountryEntity> countryEntityOptional = countryDao.findByCodeAndStatus(code, Status.ACTIVE.getValue());

        if (countryEntityOptional.isPresent()) {
            return Optional.of(countryEntityOptional
                    .map(countryEntity -> countryMapper.countryEntityToCountryDtoMapper(countryEntity))
                    .get());
        } else {
            return Optional.empty();
        }
    }
}
