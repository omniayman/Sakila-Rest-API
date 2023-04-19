package org.example.presentation.controllers;


import org.example.dtos.RentalDto;
import org.example.dtos.Staff.StaffDto;
import org.example.dtos.customer.CustomerDto;
import org.example.dtos.payment.PaymentDto;
import org.example.presistance.exceptionHandler.InvalidDataException;
import org.example.services.PaymentService;

import java.math.BigDecimal;
import java.util.List;


public class Payment {
    PaymentService paymentService = new PaymentService();

    public List<PaymentDto> getAllPayments() {

        return paymentService.getAllPayments();
    }

    public PaymentDto getPaymentById(int id) {

        return paymentService.getPaymentById(id);
    }


    public void updatePayment(PaymentDto paymentDto) {


        paymentService.updatePayment(paymentDto);
    }

    public void addPayment(PaymentDto paymentDto) throws InvalidDataException {

        paymentService.addPayment(paymentDto);
    }

    public CustomerDto getCustomerByPayment(int id) {
        return paymentService.getCustomerByPayment(id);
    }


    public RentalDto getRentalByPayment(int id) {
        return paymentService.getRentalByPayment(id);
    }


    public BigDecimal getMaxPayment() {
        return paymentService.getMaxPayment();
    }


    public StaffDto getStaffByPayment(int id) {

        return paymentService.getStaffByPayment(id);
    }
}
