package com.ticketnest.location_service.dao.repo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.ticketnest.location_service.core.enums.Status;
import com.ticketnest.location_service.enity.CountryEntity;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest(
        properties = {
            "spring.test.database.replace=none",
            "spring.datasource.url=jdbc:tc:postgresql:16-alpine://db",
        })
@Sql("/test-data.sql")
// @Import(TestcontainersConfiguration.class)  // not recommended
class CountryRepositoryTest {

    @Autowired
    private CountryRepository countryRepository;

    @Test
    void shouldGetAllActiveCountries() {
        List<CountryEntity> allCountries = countryRepository.findAllByStatus(Status.ACTIVE.getValue());

        assertThat(allCountries).hasSize(7);
    }

    @Test
    void shouldGetCountryByCode() {
        CountryEntity country = countryRepository
                .findByCodeAndStatus("IND", Status.ACTIVE.getValue())
                .orElseThrow();
        assertThat(country.getCode()).isEqualTo("IND");
        assertThat(country.getName()).isEqualTo("India");
    }
}
