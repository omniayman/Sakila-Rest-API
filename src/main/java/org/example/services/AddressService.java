package org.example.services;

import org.example.Mappers.StaffMapper;
import org.example.Mappers.StoreMapper;
import org.example.Mappers.address.AddressEditMapper;
import org.example.Mappers.address.AddressMapper;
import org.example.Mappers.customer.CustomerMapper;
import org.example.dtos.StaffDto;
import org.example.dtos.StoreDto;
import org.example.dtos.address.AddressDto;
import org.example.dtos.address.AddressEditDto;
import org.example.dtos.customer.CustomerDto;
import org.example.presistance.daos.impl.AddressDaoImpl;
import org.example.presistance.entities.Address;
import org.example.presistance.entities.Customer;
import org.example.presistance.entities.Staff;
import org.example.presistance.entities.Store;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AddressService {
    private AddressMapper mapper;
    private AddressDaoImpl addressDao;

    public AddressService() {
        addressDao = new AddressDaoImpl();
        mapper = Mappers.getMapper(AddressMapper.class);
    }

    public List<AddressDto> getAllAddresses() {
        List<Address> addresses = addressDao.findAll();
        List<AddressDto> addressDtos = new ArrayList<>();
        for (Address address : addresses) {
            addressDtos.add(mapper.toDto(address));
        }
        return addressDtos;
    }

    public AddressDto getAddressById(int id) {
        Address address = addressDao.findById(id, Address.class);
        return mapper.toDto(address);
    }

    public List<CustomerDto> getCustomerByAddress(int id) {
        CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);
        List<Customer> customers = addressDao.getCustomersByAddressId(id);
        List<CustomerDto> customerDtos = new ArrayList<>();
        for (Customer r : customers
        ) {
            customerDtos.add(customerMapper.toDto(r));
        }
        return customerDtos;
    }

    public List<StaffDto> getStaffByAddress(int id) {
        StaffMapper staffMapper = Mappers.getMapper(StaffMapper.class);
        List<Staff> staffList = addressDao.getStaffByAddressId(id);
        List<StaffDto> staffdtos = new ArrayList<>();
        for (Staff r : staffList
        ) {
            staffdtos.add(staffMapper.toDto(r));
        }
        return staffdtos;
    }

    public List<StoreDto> getStoreByAddress(int id) {
        StoreMapper storeMapper = Mappers.getMapper(StoreMapper.class);
        List<Store> stores = addressDao.getStoreByAddressId(id);
        List<StoreDto> storeDtos = new ArrayList<>();
        for (Store r : stores
        ) {
            storeDtos.add(storeMapper.toDto(r));
        }
        return storeDtos;
    }


    public void updateAddress(AddressEditDto addressDto) {
        AddressEditMapper addressMapper = Mappers.getMapper(AddressEditMapper.class);
        LocalDate localDate = LocalDate.now();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        addressDto.setLastUpdate(Date.from(localDate.atStartOfDay(defaultZoneId).toInstant()).toInstant());
        Address address = addressMapper.toEntity(addressDto);
        addressDao.update(address);
    }

    public void addAddress(AddressEditDto addressDto) {
        LocalDate localDate = LocalDate.now();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        addressDto.setLastUpdate(Date.from(localDate.atStartOfDay(defaultZoneId).toInstant()).toInstant());
        AddressEditMapper addressMapper = Mappers.getMapper(AddressEditMapper.class);
        Address address = addressMapper.toEntity(addressDto);
        addressDao.add(address);
    }
}
