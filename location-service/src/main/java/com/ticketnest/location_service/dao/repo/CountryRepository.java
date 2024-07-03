package com.ticketnest.location_service.dao.repo;

import com.ticketnest.location_service.enity.CountryEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<CountryEntity, Long> {

    public List<CountryEntity> findAllByStatus(String status);

    Optional<CountryEntity> findByCodeAndStatus(String code, String status);
}
