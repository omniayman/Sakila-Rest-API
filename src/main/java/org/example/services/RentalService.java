package org.example.services;

import org.example.Mappers.customer.CustomerMapper;
import org.example.Mappers.inventory.InventoryRentalMapper;
import org.example.Mappers.rental.RentalMapper;
import org.example.dtos.customer.CustomerDto;
import org.example.dtos.inventory.InventoryRentalDto;
import org.example.dtos.rental.RentalDto;
import org.example.presistance.daos.impl.RentalDaoImpl;
import org.example.presistance.entities.Rental;
import org.example.presistance.exceptionHandler.InvalidDataException;
import org.mapstruct.factory.Mappers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RentalService {
    private RentalMapper mapper;
    private RentalDaoImpl rentalDao;

    public RentalService() {
        rentalDao = new RentalDaoImpl();
        mapper = Mappers.getMapper(RentalMapper.class);
    }

    public List<RentalDto> getAllRentals() {
        List<Rental> rentals = rentalDao.findAll();
        List<RentalDto> rentalDtos = new ArrayList<>();
        for (Rental s : rentals) {
            rentalDtos.add(mapper.toDto(s));
        }
        return rentalDtos;
    }

    public RentalDto getRentalById(int id) {
        Rental rental = rentalDao.findById(id, Rental.class);
        return mapper.toDto(rental);
    }


    public void returnRent(int id) throws InvalidDataException {


        rentalDao.returnRent(id);
    }

    public void addRental(RentalDto rentalDto) throws InvalidDataException {

        LocalDate localDate = LocalDate.now();
        ZoneId defaultZoneId = ZoneId.systemDefault();

        rentalDto.setLastUpdate(Instant.now());
        rentalDto.setRentalDate(Date.from(localDate.atStartOfDay(defaultZoneId).toInstant()).toInstant());
        Rental rental = mapper.toEntity(rentalDto);
        rentalDao.add(rental);
    }

    public CustomerDto getCustomerByRental(int id) {
        CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);
        return customerMapper.toDto(rentalDao.getCustomerByRent(id));
    }

    public InventoryRentalDto getInventoryByRental(int id) {
        InventoryRentalMapper inventoryRentalMapper = Mappers.getMapper(InventoryRentalMapper.class);
        return inventoryRentalMapper.toDto(rentalDao.getInventoryByRent(id));
    }

}
