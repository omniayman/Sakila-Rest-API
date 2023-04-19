package org.example.presentation.controllers;


import org.example.dtos.RentalDto;
import org.example.dtos.Staff.StaffDto;
import org.example.dtos.address.AddressDto;
import org.example.dtos.customer.CustomerDto;
import org.example.dtos.film.FilmDto;
import org.example.dtos.store.StoreDto;
import org.example.dtos.store.StoreEditDto;
import org.example.presistance.exceptionHandler.InvalidDataException;
import org.example.services.StoreService;

import java.util.List;


public class Store {
    StoreService storeService = new StoreService();

    public List<StoreDto> getAllStores() {

        return storeService.getAllStores();
    }

    public StoreDto getStoreById(int id) {

        return storeService.getStoreById(id);
    }


    public void updateStore(StoreEditDto storeDto) {


        storeService.updateStore(storeDto);
    }

    public void addStore(StoreEditDto storeDto) throws InvalidDataException {

        storeService.addStore(storeDto);
    }

    public AddressDto getStoreAddress(int id) {


        return storeService.getStoreAddress(id);
    }


    public List<CustomerDto> getStoreCustomers(int id) {

        return storeService.getStoreCustomers(id);
    }


    public List<StaffDto> getStoreStaff(int id) {

        return storeService.getStoreStaff(id);
    }


    public StaffDto getStoreManager(int id) {

        return storeService.getStoreManager(id);
    }


    public List<FilmDto> getStoreFilms(int id) {

        return storeService.getStoreFilms(id);
    }


    public List<RentalDto> getStoreRentals(int id) {

        return storeService.getStoreRentals(id);
    }
}
