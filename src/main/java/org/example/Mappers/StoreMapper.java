package org.example.Mappers;

import org.example.dtos.StoreDto;
import org.example.presistance.entities.Store;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper
public interface StoreMapper {
    Store toEntity(StoreDto storeDto);

    StoreDto toDto(Store store);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Store partialUpdate(StoreDto storeDto, @MappingTarget Store store);
}