package org.example.Mappers;

import org.example.dtos.StaffDto;
import org.example.presistance.entities.Staff;
import org.mapstruct.Mapper;

@Mapper
public interface StaffMapper {
    Staff toEntity(StaffDto staffDto);

    StaffDto toDto(Staff staff);

}