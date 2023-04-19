package org.example.Mappers.store;

import org.example.dtos.store.StoreEditDto;
import org.example.presistance.entities.Store;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StoreEditMapper {
    @Mapping(source = "addressId", target = "address.id")
    @Mapping(source = "managerStaffId", target = "managerStaff.id")
    Store toEntity(StoreEditDto storeEditDto);

    @InheritInverseConfiguration(name = "toEntity")
    StoreEditDto toDto(Store store);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Store partialUpdate(StoreEditDto storeEditDto, @MappingTarget Store store);
}