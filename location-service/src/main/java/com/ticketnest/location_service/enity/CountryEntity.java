package com.ticketnest.location_service.enity;

import com.ticketnest.location_service.core.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "country_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CountryEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_seq")
    @SequenceGenerator(name = "country_seq", sequenceName = "country_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "code", nullable = false, length = 10)
    private String code;
}
