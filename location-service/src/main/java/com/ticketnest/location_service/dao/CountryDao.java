package com.ticketnest.location_service.dao;

import com.ticketnest.location_service.dao.repo.CountryRepository;
import com.ticketnest.location_service.enity.CountryEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class CountryDao {

    private CountryRepository countryRepository;

    public CountryDao(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<CountryEntity> getAllCountryByStatus(String status) {
        return countryRepository.findAllByStatus(status);
    }

    public Optional<CountryEntity> findByCodeAndStatus(String code, String status) {
        return countryRepository.findByCodeAndStatus(code, status);
    }
}
