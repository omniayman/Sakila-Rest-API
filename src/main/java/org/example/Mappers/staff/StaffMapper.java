package org.example.Mappers.staff;

import org.example.dtos.Staff.StaffDto;
import org.example.presistance.entities.Staff;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StaffMapper {
    @Mapping(source = "storeId", target = "store.id")
    @Mapping(source = "addressId", target = "address.id")
    Staff toEntity(StaffDto staffDto);

    @InheritInverseConfiguration(name = "toEntity")
    StaffDto toDto(Staff staff);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Staff partialUpdate(StaffDto staffDto, @MappingTarget Staff staff);
}