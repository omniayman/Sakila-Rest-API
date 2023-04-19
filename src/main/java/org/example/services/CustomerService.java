package org.example.services;

import org.example.Mappers.PaymentMapper;
import org.example.Mappers.RentalMapper;
import org.example.Mappers.StoreMapper;
import org.example.Mappers.address.AddressMapper;
import org.example.Mappers.customer.CustomerEditMapper;
import org.example.Mappers.customer.CustomerMapper;
import org.example.dtos.PaymentDto;
import org.example.dtos.RentalDto;
import org.example.dtos.StoreDto;
import org.example.dtos.address.AddressDto;
import org.example.dtos.customer.CustomerDto;
import org.example.dtos.customer.CustomerEditDto;
import org.example.presistance.daos.impl.CustomerDaoImpl;
import org.example.presistance.entities.*;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerService {
    private CustomerMapper mapper;
    private CustomerDaoImpl customerDao;

    public CustomerService() {
        customerDao = new CustomerDaoImpl();
        mapper = Mappers.getMapper(CustomerMapper.class);
    }

    public List<CustomerDto> getAllCustomer() {
        List<Customer> customers = customerDao.findAll();
        List<CustomerDto> customerDtos = new ArrayList<>();
        for (Customer customer : customers) {
            customerDtos.add(mapper.toDto(customer));
        }
        return customerDtos;
    }

    public CustomerDto getCustomerById(int id) {
        Customer customer = customerDao.findById(id, Customer.class);
        return mapper.toDto(customer);
    }


    public void updateCustomer(CustomerEditDto customerDto) {

        CustomerEditMapper mapper = Mappers.getMapper(CustomerEditMapper.class);
        LocalDate localDate = LocalDate.now();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        customerDto.setLastUpdate(Date.from(localDate.atStartOfDay(defaultZoneId).toInstant()));
        Customer customer = mapper.toEntity(customerDto);
        customerDao.update(customer);
    }

    public void addCustomer(CustomerEditDto customerDto) {
        CustomerEditMapper mapper = Mappers.getMapper(CustomerEditMapper.class);
        LocalDate localDate = LocalDate.now();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        customerDto.setCreateDate(Date.from(localDate.atStartOfDay(defaultZoneId).toInstant()));
        customerDto.setLastUpdate(Date.from(localDate.atStartOfDay(defaultZoneId).toInstant()));
        Customer customer = mapper.toEntity(customerDto);
        customerDao.add(customer);
    }

    public StoreDto getCustomerHomeStore(int id) {
        StoreMapper storeMapper = Mappers.getMapper(StoreMapper.class);
        Store store = customerDao.getCustomerHomeStore(id);


        return storeMapper.toDto(store);
    }

    public AddressDto getCustomerAddress(int id) {

        AddressMapper addressMapper = Mappers.getMapper(AddressMapper.class);
        Address address = customerDao.getCustomerAddress(id);
        return addressMapper.toDto(address);
    }

    public List<RentalDto> getCustomerRents(int id) {
        RentalMapper rentalMapper = Mappers.getMapper(RentalMapper.class);
        List<Rental> rentals = customerDao.getCustomerRentals(id);
        List<RentalDto> rentalDtos = new ArrayList<>();
        for (Rental r : rentals
        ) {
            rentalDtos.add(rentalMapper.toDto(r));
        }
        return rentalDtos;
    }

    public List<PaymentDto> getCustomerPayments(int id) {
        PaymentMapper paymentMapper = Mappers.getMapper(PaymentMapper.class);
        List<Payment> Payments = customerDao.getCustomerPayments(id);
        List<PaymentDto> paymentDtos = new ArrayList<>();
        for (Payment r : Payments
        ) {
            paymentDtos.add(paymentMapper.toDto(r));
        }
        return paymentDtos;
    }

}
