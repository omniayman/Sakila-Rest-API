package org.example.Mappers.customer;

import org.example.dtos.customer.CustomerDto;
import org.example.presistance.entities.Customer;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper
public interface CustomerMapper {
    CustomerDto toDto(Customer source);

    Customer toEntity(CustomerDto destination);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Customer partialUpdate(CustomerDto customerDto, @MappingTarget Customer customer);
}
