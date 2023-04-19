package org.example.Mappers.address;

import org.example.dtos.address.CityDto;
import org.example.presistance.entities.City;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper
public interface CityMapper {
    CityDto toDto(City source);

    City toEntity(CityDto destination);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    City partialUpdate(CityDto cityDto, @MappingTarget City city);
}
