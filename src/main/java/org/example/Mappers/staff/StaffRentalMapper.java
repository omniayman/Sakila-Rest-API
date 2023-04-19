package org.example.Mappers.staff;

import org.example.dtos.Staff.StaffRentalDto;
import org.example.presistance.entities.Staff;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StaffRentalMapper {
    Staff toEntity(StaffRentalDto staffRentalDto);

    StaffRentalDto toDto(Staff staff);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Staff partialUpdate(StaffRentalDto staffRentalDto, @MappingTarget Staff staff);
}