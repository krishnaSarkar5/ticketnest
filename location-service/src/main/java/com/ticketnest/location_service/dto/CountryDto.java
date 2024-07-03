package com.ticketnest.location_service.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CountryDto {

    private String code;

    private String name;
}
