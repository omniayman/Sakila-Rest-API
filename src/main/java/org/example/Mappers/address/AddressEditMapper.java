package org.example.Mappers.address;

import org.example.dtos.address.AddressEditDto;
import org.example.presistance.entities.Address;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper
public interface AddressEditMapper {
    Address toEntity(AddressEditDto addressEditDto);

    AddressEditDto toDto(Address address);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Address partialUpdate(AddressEditDto addressEditDto, @MappingTarget Address address);
}