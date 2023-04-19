package org.example.presentation.controllers;


import org.example.dtos.customer.CustomerDto;
import org.example.dtos.inventory.InventoryRentalDto;
import org.example.dtos.rental.RentalDto;
import org.example.presistance.exceptionHandler.InvalidDataException;
import org.example.services.RentalService;

import java.util.List;


public class Rental {
    RentalService rentalService = new RentalService();

    public List<RentalDto> getAllRentals() {

        return rentalService.getAllRentals();
    }

    public RentalDto getRentalById(int id) {

        return rentalService.getRentalById(id);
    }


    public void returnRent(int id) throws InvalidDataException {


        rentalService.returnRent(id);
    }

    public void addRental(RentalDto rentalDto) throws InvalidDataException {

        rentalService.addRental(rentalDto);
    }

    public CustomerDto getCustomerByRental(int id) {

        return rentalService.getCustomerByRental(id);
    }

    public InventoryRentalDto getInventoryByRent(int id) {
        return rentalService.getInventoryByRental(id);
    }

}
