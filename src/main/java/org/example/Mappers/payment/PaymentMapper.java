package org.example.Mappers.payment;

import org.example.dtos.payment.PaymentDto;
import org.example.presistance.entities.Payment;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PaymentMapper {
    @Mapping(source = "rentalId", target = "rental.id")
    @Mapping(source = "staffId", target = "staff.id")
    @Mapping(source = "customerId", target = "customer.id")
    Payment toEntity(PaymentDto paymentDto);

    @InheritInverseConfiguration(name = "toEntity")
    PaymentDto toDto(Payment payment);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Payment partialUpdate(PaymentDto paymentDto, @MappingTarget Payment payment);
}