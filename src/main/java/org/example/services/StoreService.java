package org.example.services;

import org.example.Mappers.RentalMapper;
import org.example.Mappers.address.AddressMapper;
import org.example.Mappers.customer.CustomerMapper;
import org.example.Mappers.film.FilmMapper;
import org.example.Mappers.staff.StaffMapper;
import org.example.Mappers.store.StoreEditMapper;
import org.example.Mappers.store.StoreMapper;
import org.example.dtos.RentalDto;
import org.example.dtos.Staff.StaffDto;
import org.example.dtos.address.AddressDto;
import org.example.dtos.customer.CustomerDto;
import org.example.dtos.film.FilmDto;
import org.example.dtos.store.StoreDto;
import org.example.dtos.store.StoreEditDto;
import org.example.presistance.daos.impl.StoreDaoImpl;
import org.example.presistance.entities.*;
import org.example.presistance.exceptionHandler.InvalidDataException;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class StoreService {
    private StoreMapper mapper;
    private StoreDaoImpl storeDao;

    public StoreService() {
        storeDao = new StoreDaoImpl();
        mapper = Mappers.getMapper(StoreMapper.class);
    }

    public List<StoreDto> getAllStores() {
        List<Store> stores = storeDao.findAll();
        List<StoreDto> storeDtos = new ArrayList<>();
        for (Store s : stores) {
            storeDtos.add(mapper.toDto(s));
        }
        return storeDtos;
    }

    public StoreDto getStoreById(int id) {
        Store store = storeDao.findById(id, Store.class);
        return mapper.toDto(store);
    }


    public void updateStore(StoreEditDto storeDto) {

        StoreEditMapper storeEditMapper = Mappers.getMapper(StoreEditMapper.class);
        LocalDate localDate = LocalDate.now();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        //storeDto.setLastUpdate(Date.from(localDate.atStartOfDay(defaultZoneId).toInstant()).toInstant());
        Store store = storeEditMapper.toEntity(storeDto);
        storeDao.update(store);
    }

    public void addStore(StoreEditDto storeDto) throws InvalidDataException {
        StoreEditMapper storeEditMapper = Mappers.getMapper(StoreEditMapper.class);
        LocalDate localDate = LocalDate.now();
        ZoneId defaultZoneId = ZoneId.systemDefault();

        //storeDto.setLastUpdate(Date.from(localDate.atStartOfDay(defaultZoneId).toInstant()).toInstant());
        Store store = storeEditMapper.toEntity(storeDto);
        storeDao.add(store);
    }

    public AddressDto getStoreAddress(int id) {
        AddressMapper addressMapper = Mappers.getMapper(AddressMapper.class);

        return addressMapper.toDto(storeDao.getStoreAddress(id));
    }


    public List<CustomerDto> getStoreCustomers(int id) {
        CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);
        List<CustomerDto> customerDtos = new ArrayList<>();
        List<Customer> customers = storeDao.getStoreCustomers(id);
        for (Customer s : customers
        ) {
            customerDtos.add(customerMapper.toDto(s));
        }
        return customerDtos;
    }


    public List<StaffDto> getStoreStaff(int id) {
        StaffMapper staffMapper = Mappers.getMapper(StaffMapper.class);
        List<StaffDto> staffDtos = new ArrayList<>();
        List<Staff> staffs = storeDao.getStoreStaff(id);
        for (Staff s : staffs
        ) {
            staffDtos.add(staffMapper.toDto(s));
        }
        return staffDtos;
    }


    public StaffDto getStoreManager(int id) {
        StaffMapper staffMapper = Mappers.getMapper(StaffMapper.class);
        return staffMapper.toDto(storeDao.getStoreManager(id));
    }


    public List<FilmDto> getStoreFilms(int id) {
        FilmMapper filmMapper = Mappers.getMapper(FilmMapper.class);
        List<Film> films = storeDao.getStoreFilms(id);
        List<FilmDto> filmDtos = new ArrayList<>();
        for (Film film : films) {
            filmDtos.add(filmMapper.toDto(film));
        }
        return filmDtos;
    }


    public List<RentalDto> getStoreRentals(int id) {
        RentalMapper rentalMapper = Mappers.getMapper(RentalMapper.class);
        List<RentalDto> rentalDto = new ArrayList<>();
        List<Rental> rentals = storeDao.getStoreRentals(id);
        for (Rental r : rentals
        ) {
            rentalDto.add(rentalMapper.toDto(r));
        }
        return rentalDto;
    }
}
