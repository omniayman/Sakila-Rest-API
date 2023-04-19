package org.example.Mappers.customer;

import org.example.dtos.customer.CustomerRentalDto;
import org.example.presistance.entities.Customer;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerRentalMapper {
    Customer toEntity(CustomerRentalDto customerRentalDto);

    CustomerRentalDto toDto(Customer customer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Customer partialUpdate(CustomerRentalDto customerRentalDto, @MappingTarget Customer customer);
}