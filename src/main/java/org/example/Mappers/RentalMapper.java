package org.example.Mappers;

import org.example.dtos.RentalDto;
import org.example.presistance.entities.Rental;
import org.mapstruct.*;

@Mapper
public interface RentalMapper {
    Rental toEntity(RentalDto rentalDto);

    RentalDto toDto(Rental rental);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Rental partialUpdate(RentalDto rentalDto, @MappingTarget Rental rental);

    @AfterMapping
    default void linkPayments(@MappingTarget Rental rental) {
        rental.getPayments().forEach(payment -> payment.setRental(rental));
    }
}