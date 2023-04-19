package org.example.presentation.controllers;


import org.example.dtos.PaymentDto;
import org.example.dtos.RentalDto;
import org.example.dtos.Staff.StaffDto;
import org.example.dtos.address.AddressDto;
import org.example.presistance.exceptionHandler.InvalidDataException;
import org.example.services.StaffService;

import java.util.List;


public class Staff {
    StaffService staffService = new StaffService();

    public List<StaffDto> getAllStaff() {
        System.out.println(staffService.getAllStaff().get(0).getAddressId());
        return staffService.getAllStaff();
    }

    public StaffDto getStaffById(int id) {
        return staffService.getStaffById(id);
    }

    public void updateStaff(StaffDto staffDto) {

        staffService.updateStaff(staffDto);
    }

    public void addStaff(StaffDto staffDto) throws InvalidDataException {
        staffService.addStaff(staffDto);
    }

//    public StoreDto getStaffStore(int id) {
//
//        return staffService.getStaffStore(id);
//    }


    public List<RentalDto> getStaffRentals(int id) {

        return staffService.getStaffRentals(id);
    }


    public List<PaymentDto> getStaffPayments(int id) {

        return staffService.getStaffPayments(id);
    }


    public boolean checkStaffManager(int id) {

        return staffService.checkStaffManager(id);
    }


    public long getNumberActiveStaff() {

        return staffService.getNumberActiveStaff();
    }


    public List<StaffDto> getStaffByName(String name) {


        return staffService.getStaffByName(name);

    }


    public AddressDto getStaffAddress(int id) {


        return staffService.getStaffAddress(id);

    }
}
