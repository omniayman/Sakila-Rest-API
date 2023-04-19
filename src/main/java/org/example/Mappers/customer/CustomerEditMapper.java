package org.example.Mappers.customer;

import org.example.dtos.customer.CustomerEditDto;
import org.example.presistance.entities.Customer;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper
public interface CustomerEditMapper {
    Customer toEntity(CustomerEditDto customerEditDto);

    CustomerEditDto toDto(Customer customer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Customer partialUpdate(CustomerEditDto customerEditDto, @MappingTarget Customer customer);
}