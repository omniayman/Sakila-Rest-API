package org.example.Mappers.address;

import org.example.dtos.address.CountryDto;
import org.example.presistance.entities.Country;
import org.mapstruct.Mapper;

@Mapper
public interface CountryMapper {
    CountryDto toDto(Country source);

    Country toEntity(CountryDto destination);
}
