package org.example.presentation.controllers;


import org.example.dtos.StaffDto;
import org.example.dtos.StoreDto;
import org.example.dtos.address.AddressDto;
import org.example.dtos.address.AddressEditDto;
import org.example.dtos.customer.CustomerDto;
import org.example.services.AddressService;

import java.util.List;


public class Address {

    public List<AddressDto> getAll() {
        AddressService addressService = new AddressService();
        List<AddressDto> addresses = addressService.getAllAddresses();

        return addresses;
    }

    public AddressDto getAddressById(int id) {
        AddressService addressService = new AddressService();

        return addressService.getAddressById(id);
    }

    public List<CustomerDto> getCustomerByAddress(int id) {
        AddressService addressService = new AddressService();
        return addressService.getCustomerByAddress(id);
    }

    public List<StaffDto> getStaffByAddress(int id) {
        AddressService addressService = new AddressService();
        return addressService.getStaffByAddress(id);
    }

    public List<StoreDto> getStoreByAddress(int id) {
        AddressService addressService = new AddressService();
        return addressService.getStoreByAddress(id);
    }

    public void addAddress(AddressEditDto addressDto) {
        AddressService addressService = new AddressService();
        addressService.addAddress(addressDto);

    }

    public void updateAddress(AddressEditDto addressDto) {

        AddressService addressService = new AddressService();
        addressService.updateAddress(addressDto);

    }


}
