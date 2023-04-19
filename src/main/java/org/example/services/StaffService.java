package org.example.services;

import org.example.Mappers.PaymentMapper;
import org.example.Mappers.RentalMapper;
import org.example.Mappers.StoreMapper;
import org.example.Mappers.address.AddressMapper;
import org.example.Mappers.staff.StaffMapper;
import org.example.dtos.PaymentDto;
import org.example.dtos.RentalDto;
import org.example.dtos.Staff.StaffDto;
import org.example.dtos.StoreDto;
import org.example.dtos.address.AddressDto;
import org.example.presistance.daos.impl.StaffDaoImpl;
import org.example.presistance.entities.Payment;
import org.example.presistance.entities.Rental;
import org.example.presistance.entities.Staff;
import org.example.presistance.exceptionHandler.InvalidDataException;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StaffService {
    private StaffMapper mapper;
    private StaffDaoImpl staffDao;

    public StaffService() {
        staffDao = new StaffDaoImpl();
        mapper = Mappers.getMapper(StaffMapper.class);
    }

    public List<StaffDto> getAllStaff() {
        List<Staff> staff = staffDao.findAll();
        List<StaffDto> staffDtos = new ArrayList<>();
        for (Staff s : staff) {
            staffDtos.add(mapper.toDto(s));
        }
        return staffDtos;
    }

    public StaffDto getStaffById(int id) {
        Staff staff = staffDao.findById(id, Staff.class);
        return mapper.toDto(staff);
    }


    public void updateStaff(StaffDto staffDto) {


        LocalDate localDate = LocalDate.now();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        staffDto.setLastUpdate(Date.from(localDate.atStartOfDay(defaultZoneId).toInstant()).toInstant());
        Staff staff = mapper.toEntity(staffDto);
        staffDao.update(staff);
    }

    public void addStaff(StaffDto staffDto) throws InvalidDataException {

        LocalDate localDate = LocalDate.now();
        ZoneId defaultZoneId = ZoneId.systemDefault();

        staffDto.setLastUpdate(Date.from(localDate.atStartOfDay(defaultZoneId).toInstant()).toInstant());
        Staff staff = mapper.toEntity(staffDto);
        staffDao.add(staff);
    }

    public StoreDto getStaffStore(int id) {
        StoreMapper storeMapper = Mappers.getMapper(StoreMapper.class);
        return storeMapper.toDto(staffDao.getStaffStore(id));
    }


    public List<RentalDto> getStaffRentals(int id) {
        RentalMapper rentalMapper = Mappers.getMapper(RentalMapper.class);
        List<RentalDto> rentalDto = new ArrayList<>();
        List<Rental> rentals = staffDao.getStaffRentals(id);
        for (Rental r : rentals
        ) {
            rentalDto.add(rentalMapper.toDto(r));
        }
        return rentalDto;
    }


    public List<PaymentDto> getStaffPayments(int id) {
        PaymentMapper paymentMapper = Mappers.getMapper(PaymentMapper.class);
        List<PaymentDto> paymentDtos = new ArrayList<>();
        List<Payment> payments = staffDao.getStaffPayments(id);
        for (Payment p : payments
        ) {
            paymentDtos.add(paymentMapper.toDto(p));
        }
        return paymentDtos;
    }


    public boolean checkStaffManager(int id) {

        return staffDao.checkStaffManager(id);
    }


    public long getNumberActiveStaff() {

        return staffDao.getNumberActiveStaff();
    }


    public List<StaffDto> getStaffByName(String name) {

        List<StaffDto> staffDtos = new ArrayList<>();
        List<Staff> staffs = staffDao.getStaffByName(name);
        for (Staff s : staffs
        ) {
            staffDtos.add(mapper.toDto(s));
        }
        return staffDtos;

    }


    public AddressDto getStaffAddress(int id) {
        AddressMapper addressMapper = Mappers.getMapper(AddressMapper.class);

        return addressMapper.toDto(staffDao.getStaffAddress(id));

    }
}
