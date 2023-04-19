package org.example.Mappers.address;

import org.example.dtos.address.AddressDto;
import org.example.presistance.entities.Address;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper
public interface AddressMapper {
    AddressDto toDto(Address source);

    Address toEntity(AddressDto destination);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Address partialUpdate(AddressDto addressDto, @MappingTarget Address address);
}


