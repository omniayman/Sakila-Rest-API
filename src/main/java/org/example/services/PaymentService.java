package org.example.services;

import org.example.Mappers.RentalMapper;
import org.example.Mappers.customer.CustomerMapper;
import org.example.Mappers.payment.PaymentMapper;
import org.example.Mappers.staff.StaffMapper;
import org.example.dtos.RentalDto;
import org.example.dtos.Staff.StaffDto;
import org.example.dtos.customer.CustomerDto;
import org.example.dtos.payment.PaymentDto;
import org.example.presistance.daos.impl.PaymentDaoImpl;
import org.example.presistance.entities.Payment;
import org.example.presistance.exceptionHandler.InvalidDataException;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PaymentService {
    private PaymentMapper mapper;
    private PaymentDaoImpl paymentDao;

    public PaymentService() {
        paymentDao = new PaymentDaoImpl();
        mapper = Mappers.getMapper(PaymentMapper.class);
    }

    public List<PaymentDto> getAllPayments() {
        List<Payment> payments = paymentDao.findAll();
        List<PaymentDto> paymentDtos = new ArrayList<>();
        for (Payment s : payments) {
            paymentDtos.add(mapper.toDto(s));
        }
        return paymentDtos;
    }

    public PaymentDto getPaymentById(int id) {
        Payment payment = paymentDao.findById(id, Payment.class);
        return mapper.toDto(payment);
    }


    public void updatePayment(PaymentDto paymentDto) {


        LocalDate localDate = LocalDate.now();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        paymentDto.setLastUpdate(Date.from(localDate.atStartOfDay(defaultZoneId).toInstant()).toInstant());
        paymentDto.setPaymentDate(Instant.now());
        Payment payment = mapper.toEntity(paymentDto);
        paymentDao.update(payment);
    }

    public void addPayment(PaymentDto paymentDto) throws InvalidDataException {

        LocalDate localDate = LocalDate.now();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        paymentDto.setPaymentDate(Instant.now());
        paymentDto.setLastUpdate(Date.from(localDate.atStartOfDay(defaultZoneId).toInstant()).toInstant());
        Payment payment = mapper.toEntity(paymentDto);
        paymentDao.add(payment);
    }

    public CustomerDto getCustomerByPayment(int id) {
        CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);
        return customerMapper.toDto(paymentDao.getCustomerByPayment(id));
    }


    public RentalDto getRentalByPayment(int id) {
        RentalMapper rentalMapper = Mappers.getMapper(RentalMapper.class);
        return rentalMapper.toDto(paymentDao.getRentalByPayment(id));
    }


    public BigDecimal getMaxPayment() {
        return paymentDao.getMaxPayment();
    }


    public StaffDto getStaffByPayment(int id) {
        StaffMapper staffMapper = Mappers.getMapper(StaffMapper.class);
        return staffMapper.toDto(paymentDao.getStaffByPayment(id));
    }
}
